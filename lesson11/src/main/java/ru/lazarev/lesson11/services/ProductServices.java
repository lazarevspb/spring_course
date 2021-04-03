package ru.lazarev.lesson11.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.lazarev.lesson11.dto.ProductDto;
import ru.lazarev.lesson11.model.Product;
import ru.lazarev.lesson11.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository repository;

    public Optional<ProductDto> findProductById(Long id) {
        return repository.findById(id).map(ProductDto::new);
    }

    public List<Product> findAllProduct() {
        return repository.findAll();
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return repository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
