package com.getir.retailbook.book.service;

import com.getir.retailbook.book.BookDao;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.order.dto.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookQueryServiceImpl implements BookQueryService {

    private final BookDao bookDao;

    BookQueryServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookDto> findAllBooks(List<Item> books) {
        return bookDao.findAllBooks(books);
    }

    @Override
    public BookDto findById(String bookId) {
        return  bookDao.findById(bookId);
    }
}

