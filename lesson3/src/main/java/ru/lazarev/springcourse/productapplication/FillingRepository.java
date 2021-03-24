package ru.lazarev.springcourse.productapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class FillingRepository {
    private final ProductRepository repository;

    @Autowired
    public FillingRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void postConstruct() {
        for (int i = 0; i < 5; i++) {
            repository.addProduct(new Product(i, "p" + i, (i + 1) * 10));
        }
    }
}

