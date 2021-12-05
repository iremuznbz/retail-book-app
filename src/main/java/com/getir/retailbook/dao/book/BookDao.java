package com.getir.retailbook.dao.book;

import com.getir.retailbook.dto.book.BookDto;

public interface BookDao {
    String createBook(BookDto bookDto);
}
