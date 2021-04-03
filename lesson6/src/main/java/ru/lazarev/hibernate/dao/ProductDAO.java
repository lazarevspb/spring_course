package ru.lazarev.hibernate.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.lazarev.hibernate.entity.Product;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component("productDao")
public class ProductDAO {
    Session session = null;

    @Transactional
    public Product findById(Long id) {
        Query query = session.createQuery("SELECT p FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
        return product;
    }

    @Transactional
    public void saveOrUpdate(Product product) {
        session.saveOrUpdate(product);
    }

    @Transactional
    public void deleteById(Long id) {
        Product product = session.get(Product.class, id);
        session.delete(product);
    }

    @Transactional
    public List<Product> findAll() {
        List<Product> list = session.createQuery("from Product", Product.class).getResultList();
        return list;
    }
}
