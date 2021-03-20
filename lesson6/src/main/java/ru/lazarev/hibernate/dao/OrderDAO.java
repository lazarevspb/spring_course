package ru.lazarev.hibernate.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Order;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component("orderDAO")
public class OrderDAO {
    Session session = EMF.getOpenSession();

    @Transactional
    public Order findById(Long id) {
        Query query = session.createQuery("SELECT o FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        Order order = (Order) query.getSingleResult();
        return order;
    }

    @Transactional
    public void saveOrUpdate(Order order) {
        session.saveOrUpdate(order);
    }

    @Transactional
    public void deleteById(Long id) {
        Order order = session.get(Order.class, id);
        session.delete(order);
    }

    @Transactional
    public List<Order> findAll() {
        List<Order> list = session.createQuery("from Order", Order.class).getResultList();
        return list;
    }
}
