package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by Philip Zamayeri
 * Date: 2021-04-15
 * Time: 10:15
 * Project: demo
 * Copyright: MIT
 */

@Entity
public class Friends {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String mail;
    private String adress;
    private String number;


    public Friends(Long id, String name, String mail, String adress, String number) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.adress = adress;
        this.number = number;
    }

    public Friends(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(id, friends.id) && Objects.equals(name, friends.name) && Objects.equals(mail, friends.mail) && Objects.equals(adress, friends.adress) && Objects.equals(number, friends.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mail, adress, number);
    }
}
