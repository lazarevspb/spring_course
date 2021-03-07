package ru.lazarev.springcourse.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AllProductController {
    @GetMapping("/all")
    public String homePage() {
        return "products/products";
    }
}