package ru.lazarev.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lazarev.hibernate.entity.Customer;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Customer.class);

        SessionFactory sessions = cfg.buildSessionFactory();


        sessions.close();

    }

}
