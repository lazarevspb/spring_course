package ru.lazarev.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.lazarev.hibernate.dao.CustomerDAO;
import ru.lazarev.hibernate.dao.OrderDAO;
import ru.lazarev.hibernate.dao.ProductDAO;
import ru.lazarev.hibernate.service.Service;

@Configuration
@ComponentScan("ru.lazarev.hibernate")
public class AppConfig {
    @Bean(name = "customerDAO")
    public CustomerDAO customerDAO() {
        return new CustomerDAO();
    }

    @Bean(name = "productDAO")
    public ProductDAO productDAO() {
        return new ProductDAO();
    }

    @Bean(name = "orderDAO")
    public OrderDAO orderDAO() {
        return new OrderDAO() ;
    }

    @Bean(name = "service")
    public Service service() {
        return new Service();
    }
}
