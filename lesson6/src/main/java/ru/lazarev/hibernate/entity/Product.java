package ru.lazarev.hibernate.entity;

import javax.persistence.*;

//
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name ="products", schema = "hibernate")
@NamedQueries({
        @NamedQuery(name = "Product.finAll", query = "SELECT p FROM Product p")
})
public class Product {
    @Id
    @Column(name = "id", unique=true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Column(name = "name", length = 128)
    private String name;
    @Column(name = "price")
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, price: %d", id, name, price);
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
