package com.example.db_2.POJO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employees", schema = "db_2")
@NamedQuery(name = "Employee.checkCredentials", query = "SELECT r FROM Employee r  WHERE r.email = ?1 and r.password = ?2")
@NamedQuery(name = "Employee.findByEmail", query="SELECT e FROM Employee e WHERE e.email = ?1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String email;

    private String password;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Package> packageList;

    public Employee(){}

    public Employee(String email, String password) {
        this.email=email;
        this.password=password;
    }

    public Employee(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }
}
