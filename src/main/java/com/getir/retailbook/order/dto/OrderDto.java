package com.getir.retailbook.order.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {

    private String id;
    private String customerid;
    private List<Item> books;
    private LocalDate createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public List<Item> getBooks() {
        return books;
    }

    public void setBooks(List<Item> books) {
        this.books = books;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}

