package com.example.db_2.POJO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_package")
    private int id;

    private String name;
    private float fee12;
    private float fee24;
    private float fee36;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "package_service",
            joinColumns =@JoinColumn(name = "package"),
            inverseJoinColumns = @JoinColumn(name = "service")
    )
    private List<Service> services;

    @ManyToMany
    @JoinTable(name = "package_opt_prod",
            joinColumns = @JoinColumn(name = "package"),
            inverseJoinColumns = @JoinColumn(name = "optional_product")
    )
    private List<OptionalProduct> optionalProducts;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<OptionalProduct> getOptionalProducts() {
        return optionalProducts;
    }

    public void setOptionalProducts(List<OptionalProduct> optionalProducts) {
        this.optionalProducts = optionalProducts;
    }

    public Package() {
    }

    public Package(int id) {
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
