package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookDto;

public interface BookDao {
    String createBook(BookDto bookDto);
}
