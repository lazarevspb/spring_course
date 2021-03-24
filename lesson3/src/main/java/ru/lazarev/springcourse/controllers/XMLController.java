package ru.lazarev.springcourse.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lazarev.springcourse.productapplication.Product;

import javax.xml.bind.JAXB;
import java.io.StringWriter;

@Controller
@RequestMapping("/xml")
public class XMLController {
    @GetMapping(value = "get", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXML(Model model) {
        Product product = new Product(1, "product_title", 10);
        StringWriter sw = new StringWriter();
        JAXB.marshal(product, sw);
        String xmlString = sw.toString();
        model.addAttribute("xmlString", xmlString);
        return "data/xml";
    }
}
