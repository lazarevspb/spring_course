package ru.lazarev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lazarev.services.ProductService;

@Controller
@RequestMapping("/products")
//@RequiredArgsConstructor;
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAll(Model model){

        model.addAttribute("products",  productService.findAll());
        return "products";

    }
}
