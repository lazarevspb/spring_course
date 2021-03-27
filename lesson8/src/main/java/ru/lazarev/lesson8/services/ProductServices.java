package ru.lazarev.lesson8.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lazarev.lesson8.model.Product;
import ru.lazarev.lesson8.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

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
