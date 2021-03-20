package ru.lazarev.hibernate.dao;

import org.hibernate.Session;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Customer;
import ru.lazarev.hibernate.entity.Product;

import javax.persistence.Query;
import java.util.List;

public class CustomerDAO {
    Session session = EMF.getCurrentSession();

    public Customer findById(Long id) {
        session.beginTransaction();
        Query query = session.createQuery("SELECT c FROM Customer c WHERE c.id = :id");
        query.setParameter("id", id);
        Customer customer = (Customer) query.getSingleResult();
        session.getTransaction().commit();
        return customer;
    }

    public void saveOrUpdate(Customer customer) {
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();
    }


    public List<Customer> findAll() {
        session.beginTransaction();
        List<Customer> list = session.createQuery("FROM Customer", Customer.class).getResultList();
        session.getTransaction().commit();
        return list;
    }
}
