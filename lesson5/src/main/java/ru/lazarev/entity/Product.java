package ru.lazarev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", schema = "hibernate")
@NamedQueries({
        @NamedQuery(name = "Product.finAll", query = "SELECT p FROM Product p")
})
public class Product {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Column(name = "name", length = 128)
    private String name;
    @Column(name = "cost")
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, price: %d", id, name, price);
    }
}
