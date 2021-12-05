package com.getir.retailbook.request;

import com.getir.retailbook.dto.book.BookDto;

import java.io.Serializable;

public class BookCreateRequest implements Serializable {
    private BookDto bookDto;

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
