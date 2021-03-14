package ru.lazarev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lazarev.DAO.ProductDao;
import ru.lazarev.entity.Product;

import javax.persistence.EntityManager;

/**
 * Homework for Spring course, lesson #5
 *
 * @author Valeriy Lazarev
 * @since 13.03.2021
 */
public class Lesson5Application {
    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        try {
            init();
            session = factory.getCurrentSession();
//            Product p = generateProduct();
//            dao.saveOrUpdate(session, p);
//            System.out.println(dao.findById(session, 2L));
//            dao.deleteById(session, 1L);
            dao.findAll(session).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void shutdown() {
        if (session != null) {
            session.close();
        }
        factory.close();
    }

    private static void init() {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
    }

    private static void newProduct(EntityManager em) {
        int minPrice = 0;
        int maxPrice = 1000;
        int productCount = 5;
        for (int i = 0; i < productCount; i++) {
            em.getTransaction().begin();
            em.persist(new Product("Product" + i, (int) (Math.random() * ++maxPrice) + minPrice));
            em.getTransaction().commit();
        }
    }
}
