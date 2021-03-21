package ru.lazarev.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lazarev.emf.EMF;
import ru.lazarev.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class ProductDao {
    private static Session session = EMF.getOpenSession();

    public Product findById(Long id) {
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
        session.getTransaction().commit();
        return product;
    }

    public void saveOrUpdate(Product product) {
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public List<Product> findAll() {
        session.beginTransaction();
        List<Product> list = session.createQuery("FROM Product", Product.class).getResultList();
        session.getTransaction().commit();
        return list;
    }
}
