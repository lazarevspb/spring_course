package ru.lazarev.hibernate.dao;

import org.hibernate.Session;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Order;
import ru.lazarev.hibernate.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class OrderDAO {
    Session session = EMF.getCurrentSession();

    public Order findById(Long id) {
        session.beginTransaction();
        Query query = session.createQuery("SELECT o FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        Order order = (Order) query.getSingleResult();
        session.getTransaction().commit();
        return order;
    }

    public void saveOrUpdate(Order order) {
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.delete(order);
        session.getTransaction().commit();
    }

    public List<Order> findAll() {
        session.beginTransaction();
        List<Order> list = session.createQuery("from Order", Order.class).getResultList();
        session.getTransaction().commit();
        return list;
    }
}
