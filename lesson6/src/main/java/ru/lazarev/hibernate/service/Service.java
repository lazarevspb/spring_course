package ru.lazarev.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lazarev.hibernate.dao.CustomerDAO;
import ru.lazarev.hibernate.dao.OrderDAO;
import ru.lazarev.hibernate.dao.ProductDAO;

import javax.transaction.Transactional;

@Component("service")
public class Service {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ProductDAO productDAO;


    @Transactional
    public String customerInfo(Long orderId) {
        return customerDAO.findById(orderId).toString();
    }

    @Transactional
    public  String orderInfo(Long customerId) {
        return orderDAO.findById(customerId).toString();
    }

    @Transactional
    public String productInfo(Long orderId) {
        return productDAO.findById(orderId).toString();
    }


}
