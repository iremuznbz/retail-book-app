package com.getir.retailbook.customer.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerCreateRequest implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
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
