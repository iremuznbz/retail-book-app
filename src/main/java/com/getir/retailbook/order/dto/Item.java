package com.getir.retailbook.order.dto;

import com.getir.retailbook.book.BookEntity;

public class Item {
    private BookEntity book;
    private int quantity;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
