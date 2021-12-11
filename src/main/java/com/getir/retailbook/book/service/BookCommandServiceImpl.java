package com.getir.retailbook.book.service;

import com.getir.retailbook.book.BookDao;
import com.getir.retailbook.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCommandServiceImpl implements BookCommandService {


    private final BookDao bookDao;

    public BookCommandServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String createBook(BookDto bookDto) {
       return bookDao.createBook(bookDto);
    }

    @Override
    public void updateBooks(List<BookDto> books) {
        bookDao.updateBooks(books);
    }

    @Override
    public void updateBookStock(String id, int quantity) {
        bookDao.updateBookStock(id, quantity);
    }
}



