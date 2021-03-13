package ru.lazarev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lazarev.exception.ResourceNotFoundException;
import ru.lazarev.model.Product;
import ru.lazarev.services.ProductsService;

import java.util.Optional;
import java.util.Properties;

@Controller
@RequestMapping("/products")
//@RequiredArgsConstructor;
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showAll(Model model,
                          @RequestParam(required = false, name = "min_price") Integer minPrice,
                          @RequestParam(required = false, name = "max_price") Integer maxPrice
    ) {
        model.addAttribute("products", productsService.findAll(minPrice, maxPrice));
        return "products";

    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productsService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable Long id) {
  Optional<Product> product = productsService.findById(id);
        model.addAttribute("product", productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден")));
        return "product";
    }

}
