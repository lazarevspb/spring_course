package ru.lazarev.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarev.hibernate.config.AppConfig;
import ru.lazarev.hibernate.service.Service;

/**
 * Homework for lesson #7
 *
 * @author Valeriy Lazarev
 * @since 20.03.2021
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ru.lazarev.hibernate.config.AppConfig.class);
        Service service = context.getBean("service", Service.class);
        System.out.println(service.orderInfo(2L));
        System.out.println(service.customerInfo(2L));
    }
}
