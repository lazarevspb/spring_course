package ru.lazarev.lesson10.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.lazarev.lesson10.dto.ProductDto;
import ru.lazarev.lesson10.model.Product;
import ru.lazarev.lesson10.repositories.ProductRepository;

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

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return repository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

//    public List<Product> findAllByPrice(Integer min, Integer max) {
//        return repository.findAllByPriceBetween(min, max);
//    }

    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
