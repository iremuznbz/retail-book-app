package com.getir.retailbook.customer.dto;


import java.io.Serializable;

public class CustomerDto implements Serializable {

    private String id;
    private String name;
    private String surname;
    private String email;

    public CustomerDto(){

    }
    public CustomerDto(String name, String surname, String email) {
        this(null, name, surname, email);
    }

    public CustomerDto(String id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}