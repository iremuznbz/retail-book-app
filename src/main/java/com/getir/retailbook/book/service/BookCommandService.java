package com.getir.retailbook.book.service;

import com.getir.retailbook.book.dto.BookDto;

import java.util.List;

public interface BookCommandService {
    String createBook(BookDto bookDto);

    void updateBooks(List<BookDto> books);

    void updateBookStock(String id, int quantity);
}
