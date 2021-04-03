package ru.lazarev.lesson9.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lazarev.lesson9.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
