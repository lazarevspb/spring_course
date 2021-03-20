package ru.lazarev.hibernate.entity;


import javax.persistence.*;


@Entity
@Table(name = "products", schema = "hibernate")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private long cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, cost: %s, orders_id: %s", id, name, cost, order.getId());
    }
}
