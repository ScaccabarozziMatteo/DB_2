package com.example.db_2.POJO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products_sales")
public class ProductReport {
    @Id
    private int optional_product;
    private String name;
    private float total_sales;

    public ProductReport() {
    }

    public int getOptional_product() {
        return optional_product;
    }

    public void setOptional_product(int optional_product) {
        this.optional_product = optional_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(float total_sales) {
        this.total_sales = total_sales;
    }
}
