package ru.lazarev.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lazarev.hibernate.entity.Person;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class);

        SessionFactory sessions = cfg.buildSessionFactory();


        sessions.close();

    }

}
