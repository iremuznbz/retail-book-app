package com.getir.retailbook.order.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

    @NotNull
    private String bookId;
    @Positive
    private int quantity;
    @Positive
    private BigDecimal totalAmount;

    public Item() {

    }

    public Item(String id, Integer quantity, BigDecimal totalAmount) {
        this.bookId = id;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
