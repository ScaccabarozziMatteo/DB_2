package com.example.db_2.POJO;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order")
    private int id;

    private LocalDateTime timestamp;
    private LocalDate start_subs;
    private int validity;
    private int status;
    private float total_costs;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "package")
    private Package Package;

    @ManyToMany
    @JoinTable(name = "order_opt_products",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "optional_product")
    )
    private List<OptionalProduct> optionalProducts;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getStart_subs() {
        return start_subs;
    }

    public void setStart_subs(LocalDate start_subs) {
        this.start_subs = start_subs;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal_costs() {
        return total_costs;
    }

    public void setTotal_costs(float total_costs) {
        this.total_costs = total_costs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.example.db_2.POJO.Package getPackage() {
        return Package;
    }

    public void setPackage(com.example.db_2.POJO.Package aPackage) {
        Package = aPackage;
    }

    public List<OptionalProduct> getOptionalProducts() {
        return optionalProducts;
    }

    public void setOptionalProducts(List<OptionalProduct> optionalProducts) {
        this.optionalProducts = optionalProducts;
    }
}
