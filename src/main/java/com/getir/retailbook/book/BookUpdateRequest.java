package com.getir.retailbook.book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class BookUpdateRequest implements Serializable {

    @NotEmpty(message = "Book id cannot be null")
    private String bookId;

    @PositiveOrZero(message = "Quantity cannot be null and negative")
    private int quantity;

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
}
