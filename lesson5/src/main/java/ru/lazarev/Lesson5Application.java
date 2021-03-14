package ru.lazarev;

import org.hibernate.cfg.Configuration;
import ru.lazarev.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Homework for Spring course, lesson #5
 *
 * @author Valeriy Lazarev
 * @since 13.03.2021
 */
public class Lesson5Application {

    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();



        EntityManager em = factory.createEntityManager();
//        newProduct(em);

//        setProduct(em);

//        findProduct(em);

        em.createNamedQuery("Product.finAll", Product.class).getResultList().forEach(System.out::println);


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

    private static void setProduct(EntityManager em) {
        Lesson5Application.em = em;
        Product product1 = em.find(Product.class, 6L);
        em.getTransaction().begin();
        product1.setPrice(000);
        em.merge(product1);
        em.getTransaction().commit();
        System.out.println(product1);
    }

    private static void findProduct(EntityManager em) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.name = :name");
        query.setParameter("name", "Product1");


        Product product1;


        try {
            product1 = (Product) query.getSingleResult();
            System.out.println(product1.toString());
        } catch (NoResultException e) {
            System.out.println("Product not found");
        }

    }
}
