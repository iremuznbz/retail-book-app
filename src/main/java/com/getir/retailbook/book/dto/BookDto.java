package com.getir.retailbook.book.dto;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

public class BookDto implements Serializable {

    private String id;
    private String name;
    private String author;

    @PositiveOrZero
    private Integer stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
