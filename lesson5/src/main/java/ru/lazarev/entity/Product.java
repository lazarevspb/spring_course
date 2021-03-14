package ru.lazarev.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="products")
public class Product {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "name", length = 128)
    private String name;
    private int price;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, price: %s", id, name, price);
    }
}
