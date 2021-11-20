package com.example.db_2.POJO;

import javax.persistence.*;

@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_service")
    private Integer id;

    //enum('fixed phone','mobile phone','fixed internet','mobile internet')
    private String type;
    private Integer minutes;
    private Integer sms;
    private Integer internet;
    private Float minutes_fee;
    private Float sms_fee;
    private Float internet_fee;

    public Service() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    public Float getMinutes_fee() {
        return minutes_fee;
    }

    public void setMinutes_fee(Float minutes_fee) {
        this.minutes_fee = minutes_fee;
    }

    public Float getSms_fee() {
        return sms_fee;
    }

    public void setSms_fee(Float sms_fee) {
        this.sms_fee = sms_fee;
    }

    public Float getInternet_fee() {
        return internet_fee;
    }

    public void setInternet_fee(Float internet_fee) {
        this.internet_fee = internet_fee;
    }
}
