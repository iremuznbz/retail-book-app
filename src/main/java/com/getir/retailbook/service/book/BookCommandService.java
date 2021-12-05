package com.getir.retailbook.service.book;

import com.getir.retailbook.dto.book.BookDto;

public interface BookCommandService {
    String createBook(BookDto bookDto);
}
