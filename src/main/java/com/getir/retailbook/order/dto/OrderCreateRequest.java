package com.getir.retailbook.order.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class OrderCreateRequest {

    @NotEmpty(message = "Customer id cannot be null")
    private String customerId;

    @NotEmpty(message = "Book list cannot be empty")
    private List<Item> books;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Item> getBooks() {
        return books;
    }

    public void setBooks(List<Item> books) {
        this.books = books;
    }
}
