package ru.lazarev.hibernate.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers", schema = "hibernate")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  public Customer() {
  }

  //  @Column(name = "orders_id")
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<Order> orders;

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
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

  @Override
  public String toString() {
    return String.format("id: %s, name: %s, orders_id: %s", id, name, orders);
  }


}
