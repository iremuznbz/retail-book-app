package com.getir.retailbook.book.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

public class BookCreateRequest implements Serializable {
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "Author cannot be null")
    private String author;

    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity must be greater than or equal to 0")
    private int quantity;

    @NotNull(message = "Amount cannot be null and negative")
    @Positive
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
