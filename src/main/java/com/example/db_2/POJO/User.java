package com.example.db_2.POJO;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
@NamedQuery(name = "User.checkCredentials", query = "SELECT r FROM User r  WHERE r.email = ?1 and r.password = ?2")
@NamedQuery(name = "User.findByEmail", query="SELECT u FROM User u WHERE u.email = ?1")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean insolvent;

    @ManyToMany
    @JoinTable(name= "products_queues",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product"))
    private List<OptionalProduct> product_queue;

    @ManyToMany
    @JoinTable(name= "services_queues",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service"))
    private List<Service> service_queues;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<com.example.db_2.POJO.OptionalProduct> getProduct_queue() {
        return product_queue;
    }

    public void setProduct_queue(List<com.example.db_2.POJO.OptionalProduct> product_queue) {
        this.product_queue = product_queue;
    }

    public List<com.example.db_2.POJO.Service> getService_queues() {
        return service_queues;
    }

    public void setService_queues(List<com.example.db_2.POJO.Service> service_queues) {
        this.service_queues = service_queues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInsolvent() {
        return insolvent;
    }

    public void setInsolvent(boolean insolvent) {
        this.insolvent = insolvent;
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
