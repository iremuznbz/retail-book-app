package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.order.dto.Item;

import java.util.List;

public interface BookDao {
    String createBook(BookDto bookDto);

    List<BookDto> findAllBooks(List<Item> books);

    Object findById(String bookId);

    void updateBooks(List<BookDto> books);
}
