package com.codegym.model;

public class Customer {

    private int id;
    private String name;
    private String address;
    private String gender;
    private String avatar;

    public Customer() {
    }

    public Customer(int id, String name, String address, String gender, String avatar) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
