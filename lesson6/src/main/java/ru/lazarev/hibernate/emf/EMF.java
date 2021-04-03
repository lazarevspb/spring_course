package ru.lazarev.hibernate.emf;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
public class EMF {
    private static SessionFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();

    public static Session getOpenSession() {

        return factory.openSession();

    }

    public static void close() {
        if (factory != null) {
            factory.close();
        }
    }
}
