package com.example.db_2.POJO;

import javax.persistence.*;

@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service")
    private int id;

    //enum('fixed phone','mobile phone','fixed internet','mobile internet')
    private String type;
    private int minutes;
    private int sms;
    private int internet;
    private float minutes_fee;
    private float sms_fee;
    private float internet_fee;

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public float getMinutes_fee() {
        return minutes_fee;
    }

    public void setMinutes_fee(float minutes_fee) {
        this.minutes_fee = minutes_fee;
    }

    public float getSms_fee() {
        return sms_fee;
    }

    public void setSms_fee(float sms_fee) {
        this.sms_fee = sms_fee;
    }

    public float getInternet_fee() {
        return internet_fee;
    }

    public void setInternet_fee(float internet_fee) {
        this.internet_fee = internet_fee;
    }
}
