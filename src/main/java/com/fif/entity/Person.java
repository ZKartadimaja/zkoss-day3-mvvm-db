package com.fif.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "userName")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "fullName")
    String fullName;

    @Column(name = "gender")
    String gender;

    @Temporal(TemporalType.TIMESTAMP)
    Date birthdayDate;

    @Column(name = "city")
    String city;

    @Column(name = "province")
    String province;

    @Column(name = "luckyNumber")
    Integer luckyNumber;

    public Person() {
    }

    public Person(String username, String password, String fullName, String gender, Date birthdayDate, String province, String city, int luckyNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
        this.province = province;
        this.city = city;
        this.luckyNumber = luckyNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(Integer luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

}