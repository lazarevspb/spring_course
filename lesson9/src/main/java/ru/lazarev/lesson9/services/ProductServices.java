package ru.lazarev.lesson9.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lazarev.lesson9.model.Product;
import ru.lazarev.lesson9.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository repository;

    public Optional<Product> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAllProduct() {
        return repository.findAll();
    }

    public List<Product> findAllByPrice(Integer min, Integer max) {
        return repository.findAllByPriceBetween(min, max);
    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
