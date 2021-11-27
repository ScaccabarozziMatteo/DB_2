package com.example.db_2.POJO;


import javax.persistence.*;

@Entity
@Table(name = "opt_products")
public class OptionalProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_opt_prod")
    private int id;

    private String name;
    private float monthly_fee;

    public OptionalProduct() {
    }

    public OptionalProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMonthly_fee() {
        return monthly_fee;
    }

    public void setMonthly_fee(float monthly_fee) {
        this.monthly_fee = monthly_fee;
    }
}
