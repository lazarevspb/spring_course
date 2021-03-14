package ru.lazarev;


import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * Homework for Spring course, lesson #5
 *
 * @author Valeriy Lazarev
 * @since 13.03.2021
 */
public class Lesson5Application {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();

    }
}
