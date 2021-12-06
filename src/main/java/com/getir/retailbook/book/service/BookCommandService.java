package com.getir.retailbook.book.service;

import com.getir.retailbook.book.dto.BookDto;

public interface BookCommandService {
    String createBook(BookDto bookDto);
}
