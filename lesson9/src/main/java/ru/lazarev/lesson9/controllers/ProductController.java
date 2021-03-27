package ru.lazarev.lesson9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.lazarev.lesson9.dto.ProductDto;
import ru.lazarev.lesson9.model.Product;
import ru.lazarev.lesson9.repositories.specifications.ProductSpecifications;
import ru.lazarev.lesson9.services.ProductServices;

import java.util.List;

//@RequestMapping("/products")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServices services;

    //`http://localhost:8189/market/api/v1/index.html`
    @GetMapping
    public Page<ProductDto> findAllProducts(
//            @RequestParam(name = "min_price", defaultValue = "0") Integer minPrice,
//            @RequestParam(name = "max_price", required = false) Integer maxPrice,
//            @RequestParam(name = "title", required = false) String title,
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return services.findAll(ProductSpecifications.build(params), page, 2);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return services.findProductById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return services.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return services.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        services.deleteProductById(id);
    }
}
