package ru.lazarev.hibernate.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lazarev.hibernate.dao.CustomerDAO;
import ru.lazarev.hibernate.dao.OrderDAO;
import ru.lazarev.hibernate.dao.ProductDao;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Product;

import javax.persistence.Query;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

public class Service {
    private final Session session = EMF.getCurrentSession();
    private final ProductDao pd;
    private final OrderDAO od;
    private final CustomerDAO cd;


    public Service() {
        this.pd = new ProductDao();
        this.od = new OrderDAO();
        this.cd = new CustomerDAO();
    }


    @Transactional
    public String customerInfo(Long orderId) {
        return new CustomerDAO().findById(orderId).toString();
    }

    @Transactional
    public String orderInfo(Long customerId) {
        return new OrderDAO().findById(customerId).toString();
    }

    @Transactional
    public String productInfo(Long orderId) {
        return new ProductDao().findById(orderId).toString();
    }


}
