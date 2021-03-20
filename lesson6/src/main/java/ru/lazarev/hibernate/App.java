package ru.lazarev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import ru.lazarev.hibernate.emf.EMF;
import ru.lazarev.hibernate.entity.Customer;
import ru.lazarev.hibernate.entity.Order;
import ru.lazarev.hibernate.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        Configuration cfg = new Configuration()
//                .addAnnotatedClass(Customer.class);
        SessionFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
        Session session = null;


        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Product p = session.find(Product.class, 2L);
//            Order p = session.find(Order.class, 2L);
            Customer p = session.find(Customer.class, 2L);
//            NativeQuery p = session.createNativeQuery("select * from products");
//            List<Product> items = session.createQuery("from Product ").getResultList();

//            System.out.println(items);
//            Order p = session.find(Order.class, 2L);
//            Customer p = session.find(Customer.class, 2L);
//            p.stream().forEach(System.out::println);
            System.out.println(p);

            session.getTransaction().commit();
        } finally {
            session.close();

        }

    }

}
