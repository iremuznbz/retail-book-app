package com.getir.retailbook.book;

import java.io.Serializable;

public class BookUpdateRequest implements Serializable {

    private String bookId;
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
