package ru.lazarev.lesson10.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.lazarev.lesson10.dto.ProductDto;
import ru.lazarev.lesson10.exceprion_handling.ResourceNotFoundException;
import ru.lazarev.lesson10.model.Product;
import ru.lazarev.lesson10.repositories.specifications.ProductSpecifications;
import ru.lazarev.lesson10.services.ProductServices;


@RestController
@RequestMapping("/api/v2/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServices services;

    //`http://localhost:8190/market/index.html`
    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }

        //http://localhost:8190/market/api/v2/products/
        return services.findAll(ProductSpecifications.build(params), page, 5);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
    return services.findProductById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String
                    .format("id %s not found", id)));
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
