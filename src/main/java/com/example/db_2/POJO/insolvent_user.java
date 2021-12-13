package com.example.db_2.POJO;


import javax.persistence.*;

@Entity
@Table(name="insolvent_users")
@NamedQuery(name = "InsolventfindAll", query="SELECT i FROM insolvent_user i")
public class insolvent_user {
    @Id
    @Column(name = "idinsolvent_users")
    private int insolvent_user;
    private String email;
    private String username;

    public insolvent_user() {
    }

    public int getInsolvent_user() {
        return insolvent_user;
    }

    public void setInsolvent_user(int insolvent_user) {
        this.insolvent_user = insolvent_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
