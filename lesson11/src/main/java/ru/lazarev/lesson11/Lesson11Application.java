package ru.lazarev.lesson11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Homework for lesson #11
 *
 * @author Valeriy Lazarev
 * @since 03.04.2021
 */
@SpringBootApplication
public class Lesson11Application {
    public static void main(String[] args) {
        SpringApplication.run(Lesson11Application.class, args);
    }
}
/*
        http://localhost:8190/market/h2-console/

        http://localhost:8190/market/users.html

        http://localhost:8190/market/index.html
        http://localhost:8190/market/api/v2/products/

        http://localhost:8190/market/swagger-ui.html

        http://localhost:8190/market/api/v2/cart/
        http://localhost:8190/market/api/v2/cart/all
        http://localhost:8190/market/api/v2/cart/add/10
        http://localhost:8190/market/api/v2/cart/delete/10

*/
