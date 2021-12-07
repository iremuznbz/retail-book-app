package com.getir.retailbook.customer.dto;


import com.getir.retailbook.customer.CustomerEntity;

import java.io.Serializable;
import java.util.StringJoiner;

public class CustomerDto implements Serializable {

    private String id;
    private String name;
    private String surname;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .toString();
    }

}