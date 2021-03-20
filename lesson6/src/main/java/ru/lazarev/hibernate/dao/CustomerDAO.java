package ru.lazarev.hibernate.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Customer;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component("customerDAO")
public class CustomerDAO {
    Session session = EMF.getOpenSession();

    @Transactional
    public Customer findById(Long id) {
        Query query = session.createQuery("SELECT c FROM Customer c WHERE c.id = :id");
        query.setParameter("id", id);
        Customer customer = (Customer) query.getSingleResult();
        return customer;
    }

    @Transactional
    public void saveOrUpdate(Customer customer) {
        session.saveOrUpdate(customer);
    }

    @Transactional
    public void deleteById(Long id) {
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }

    @Transactional
    public List<Customer> findAll() {
        List<Customer> list = session.createQuery("FROM Customer", Customer.class).getResultList();
        return list;
    }
}
