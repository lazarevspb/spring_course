package ru.lazarev.springcourse.productapplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {
    private List<Product> list = new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public void addProduct(Product product) {
        this.list.add(product);
    }

    @Override
    public String toString() {
        return list.stream()
                .map(Product::getName)
                .collect(Collectors.joining("::", "the_collection_contains: [", "]"));
    }
}
