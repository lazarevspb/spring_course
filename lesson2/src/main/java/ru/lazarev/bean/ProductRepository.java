package ru.lazarev.bean;

import org.springframework.stereotype.Component;
import ru.lazarev.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart,
в который можно добавлять и удалять товары по id.*/
@Component
public class ProductRepository {
    private List<Product> list = new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public Product getProductById(int index) {
        return this.list.get(index);
    }

    public void addProduct(Product product) {
        this.list.add(product);
    }

    public int getSize() {
        return this.list.size();
    }

    @Override
    public String toString() {

        return list.stream()
                .map(Product::getName)
                .collect(Collectors.joining("::", "the_collection_contains: [", "]"));
    }
}
