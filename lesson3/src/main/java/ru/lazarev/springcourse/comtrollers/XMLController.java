package ru.lazarev.springcourse.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lazarev.springcourse.product_application.Product;

import javax.xml.bind.JAXB;
import java.io.*;

@Controller
public class XMLController {
    @GetMapping("xml/get")
    public String getXML(Model model){
        Product product = new Product(1, "product_title", 10);
        StringWriter sw = new StringWriter();
        JAXB.marshal(product, sw);
        String xmlString = sw.toString();
        model.addAttribute("xmlString", xmlString);
        return "xml";
    }
}