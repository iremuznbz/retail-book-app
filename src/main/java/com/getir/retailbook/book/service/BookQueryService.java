package com.getir.retailbook.book.service;

import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.order.dto.Item;

import java.util.List;

public interface BookQueryService {
    List<BookDto> findAllBooks(List<Item> books);

    BookDto findById(String bookId);
}
