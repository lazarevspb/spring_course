package ru.lazarev.repositories;

import org.springframework.stereotype.Component;
import ru.lazarev.exception.ResourceNotFoundException;
import ru.lazarev.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductsRepository {
    private List<Product> products;
    private static Long PRODUCTS_COUNT = 0L;

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        int minPrice = 0;
        int maxPrice = 1000;

        this.products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product(
                    ++PRODUCTS_COUNT,
                    "Product_" + PRODUCTS_COUNT,
                    (int) (Math.random() * ++maxPrice) + minPrice));
        }

    }

    public Product saveOrUpdateProduct(Product product) {

        if (product.getId() != 0) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);
                    return product;
                }
            }
        }

        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        product.setId(newId);
        this.products.add(product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }


    @Override
    public String toString() {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.joining("::", "the_collection_contains: [", "]"));
    }
}
