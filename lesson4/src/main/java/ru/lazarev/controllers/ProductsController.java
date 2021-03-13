package ru.lazarev.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lazarev.exception.ResourceNotFoundException;
import ru.lazarev.model.Product;
import ru.lazarev.services.ProductsService;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;

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
        return "index";

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

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping()
    public String createProduct(@ModelAttribute("product") Product product) {
        productsService.saveOrUpdate(product);
        System.out.println(productsService.toString());
        return "redirect:/products";
    }

    @GetMapping("get_json/{id}")
    public String getJson(Model model, @PathVariable Long id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден"));
        String jsonString = objectMapper.writeValueAsString(product);
        model.addAttribute("receivedText", jsonString);
        return "json_view";
    }


    @GetMapping("get_xml/{id}")
    public String getXML(Model model, @PathVariable Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт не найден"));
        StringWriter sw = new StringWriter();
        JAXB.marshal(product, sw);
        String xmlString = sw.toString();
        model.addAttribute("xmlString", xmlString);
        return "xml_view";
    }

}
