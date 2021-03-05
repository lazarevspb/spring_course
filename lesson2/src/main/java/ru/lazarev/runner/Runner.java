package ru.lazarev.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.lazarev.Product;
import ru.lazarev.bean.Cart;
import ru.lazarev.bean.ProductRepository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class Runner implements CommandLineRunner, BeanPostProcessor {
    private Cart cart;
    private final ProductRepository repository;
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void postConstruct() {
        for (int i = 0; i < 5; i++) {
            repository.addProduct(new Product(i, "p" + i, (i + 1) * 10));
        }
        System.out.println("postCont");
    }

    @Autowired
    public Runner(Cart cart, ProductRepository repository) {
        this.cart = cart;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        InputStream in = System.in;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
            String input;
            while (true) {
                System.out.println("Введите \"add ID\" продукта для добавления товара в корзину или\n\"new\" для создания новой корзины : ");
                input = bufferedReader.readLine().trim();

                switch (input.split(" ")[0]) {
                    case "add":
                        System.out.println("add");
                        cart.addProductToCart(Integer.parseInt(input.split(" ")[1]));
                        break;
                    case "del":
                        System.out.println("del");
                        cart.removeProductToCart(Integer.parseInt(input.split(" ")[1]));
                        break;

                    case "new":
                        System.out.println("new");
                        cart = (Cart) applicationContext.getBean("cart");
                        System.out.println(cart);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + input);
                }
                System.out.println(cart.toString());
            }
        }
    }
}
