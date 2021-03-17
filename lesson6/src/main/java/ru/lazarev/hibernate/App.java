package ru.lazarev.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addClass(Person.class);

        SessionFactory sessions = cfg.buildSessionFactory();


        sessions.close();

    }

}
