package com.getir.retailbook.order.dto;

public class Item {

    private String bookId;
    private int quantity;

    public Item(String id, Integer quantity) {
        this.bookId = id;
        this.quantity = quantity;
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

}
