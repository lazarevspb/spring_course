package ru.lazarev.hibernate;

import org.hibernate.Session;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.service.Service;

public class App {
    private static final Session session = EMF.getCurrentSession();
    private static final Service service = new Service();

    public static void main(String[] args) {

        try {
            System.out.println(service.orderInfo(2L));
            System.out.println(service.customerInfo(2L));
        } finally {
            session.close();
        }
    }
}
