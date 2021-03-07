package ru.lazarev.springcourse.comtrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lazarev.springcourse.product_application.Product;

import java.io.IOException;

@Controller
public class JSONController {
    @GetMapping("/json/get")
    public String getJson(Model model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = new Product(1, "product_title", 10);
        String jsonString = objectMapper.writeValueAsString(product);
        model.addAttribute("receivedText", jsonString);
        return "json";
    }




}