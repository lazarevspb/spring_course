package ru.lazarev.DAO;

import org.hibernate.Session;
import ru.lazarev.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDao {
    public Product findById(Session session, Long id) {
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
//        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public void saveOrUpdate(Session session, Product product) {
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }

    public void deleteById(Session session, Long id) {
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public List<Product> findAll(Session session) {
        session.beginTransaction();
        List<Product> list = session.createNamedQuery("Product.finAll", Product.class).getResultList();
        session.getTransaction().commit();
        return list;
    }
}
