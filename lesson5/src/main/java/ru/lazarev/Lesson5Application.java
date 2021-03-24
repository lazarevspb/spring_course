package ru.lazarev;

import ru.lazarev.DAO.ProductDao;
import ru.lazarev.emf.EMF;
import ru.lazarev.entity.Product;

import javax.persistence.EntityManager;

/**
 * Homework for Spring course, lesson #5
 *
 * @author Valeriy Lazarev
 * @since 13.03.2021
 */
public class Lesson5Application {
    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        try {
//            Product p = generateProduct();
//            dao.saveOrUpdate(session, p);
//            System.out.println(dao.findById(session, 2L));
//            dao.deleteById(session, 1L);
            dao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EMF.close();
        }
    }

    private static void fillingTheBaseWithProducts(EntityManager em) {
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
