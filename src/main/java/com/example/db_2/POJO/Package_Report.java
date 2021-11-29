package com.example.db_2.POJO;

import javax.persistence.*;

@Entity
@Table(name="package_reports")
@NamedQuery(name = "Employee.findAll", query="SELECT p FROM Package_Report p")
@NamedQuery(name = "Employee.findByPackage", query="SELECT p FROM Package_Report p where p.aPackage=?1")
public class Package_Report {

    @Id
    @Column(name="package")
    int aPackage;
    int total_purchase;
    int purchase_24;
    int purchase_24_36;
    int purchase_36;
    float total_revenue;
    float total_revenue_prod;
    int total_prod;

    public Package_Report() {
    }

    public int getaPackage() {
        return aPackage;
    }

    public void setaPackage(int aPackage) {
        this.aPackage = aPackage;
    }

    public int getTotal_purchase() {
        return total_purchase;
    }

    public void setTotal_purchase(int total_purchase) {
        this.total_purchase = total_purchase;
    }

    public int getPurchase_24() {
        return purchase_24;
    }

    public void setPurchase_24(int purchase_24) {
        this.purchase_24 = purchase_24;
    }

    public int getPurchase_24_36() {
        return purchase_24_36;
    }

    public void setPurchase_24_36(int purchase_24_36) {
        this.purchase_24_36 = purchase_24_36;
    }

    public int getPurchase_36() {
        return purchase_36;
    }

    public void setPurchase_36(int purchase_36) {
        this.purchase_36 = purchase_36;
    }

    public float getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(float total_revenue) {
        this.total_revenue = total_revenue;
    }

    public float getTotal_revenue_prod() {
        return total_revenue_prod;
    }

    public void setTotal_revenue_prod(float total_revenue_prod) {
        this.total_revenue_prod = total_revenue_prod;
    }

    public int getTotal_prod() {
        return total_prod;
    }

    public void setTotal_prod(int total_prod) {
        this.total_prod = total_prod;
    }

    public float getAvgProd(){
        return (float)total_prod/(float)total_purchase;
    }
}
