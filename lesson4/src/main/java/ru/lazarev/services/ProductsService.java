package ru.lazarev.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lazarev.model.Product;
import ru.lazarev.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public List<Product> findAll(Integer minPrice, Integer maxPrice) {
        List<Product> out = findAll();
        if (minPrice != null) {
            out = out.stream()
                    .filter(product -> product.getPrice() >= minPrice)
                    .collect(Collectors.toList());

        }
        if (maxPrice != null) {
            out = out.stream()
                    .filter(product -> product.getPrice() <= maxPrice)
                    .collect(Collectors.toList());

        }
        return out;
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.saveOrUpdateProduct(product);
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

}
