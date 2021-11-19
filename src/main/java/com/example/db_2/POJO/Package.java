package com.example.db_2.POJO;

import javax.persistence.*;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_package")
    private int id;

    private String name;
    private float fee12;
    private float fee24;
    private float fee36;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    public Package() {
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

    public float getFee12() {
        return fee12;
    }

    public void setFee12(float fee12) {
        this.fee12 = fee12;
    }

    public float getFee24() {
        return fee24;
    }

    public void setFee24(float fee24) {
        this.fee24 = fee24;
    }

    public float getFee36() {
        return fee36;
    }

    public void setFee36(float fee36) {
        this.fee36 = fee36;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
