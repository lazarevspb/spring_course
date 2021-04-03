package ru.lazarev.lesson10.controllers;


import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "receive all products")
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

    @ApiOperation(value = "receive the product by ID")
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
    return services.findProductById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String
                    .format("id %s not found", id)));
    }
    @ApiOperation(value = "Saving the product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return services.saveOrUpdate(product);
    }

    @ApiOperation(value = "Updating the product")
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return services.saveOrUpdate(product);
    }
    @ApiOperation(value = "Remove product by ID")
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        services.deleteProductById(id);
    }
}
