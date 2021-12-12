package com.example.db_2.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="suspended_orders")
public class suspendedOrder {
    @Id
    @Column(name = "id_order")
    private int id;

    private LocalDateTime timestamp;
    private LocalDate start_subs;
    private int validity;
    private int status;
    private float total_costs;

    @Column(name = "user_id")
    private int user;

    @Column(name = "package")
    private int aPackage;

    public suspendedOrder() {
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getaPackage() {
        return aPackage;
    }

    public void setaPackage(int aPackage) {
        this.aPackage = aPackage;
    }
}
