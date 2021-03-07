package ru.lazarev.springcourse.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AddProductController {
    @GetMapping("/add")
    public String homePage() {
        return "products/add_products";
    }
}