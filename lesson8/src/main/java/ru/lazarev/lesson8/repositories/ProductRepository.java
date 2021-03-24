package ru.lazarev.lesson8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lazarev.lesson8.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
