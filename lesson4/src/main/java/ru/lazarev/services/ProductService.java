package ru.lazarev.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lazarev.model.Product;
import ru.lazarev.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.saveOrUpdateProduct();
    }

}
