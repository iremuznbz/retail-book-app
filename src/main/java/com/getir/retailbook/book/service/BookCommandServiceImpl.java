package com.getir.retailbook.book.service;

import com.getir.retailbook.book.BookDao;
import com.getir.retailbook.book.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookCommandServiceImpl implements BookCommandService {

    @Autowired
    private BookDao bookDao;

    @Override
    public String createBook(BookDto bookDto) {
       return bookDao.createBook(bookDto);
    }

    @Override
    public void updateBooks(List<BookDto> books) {
        bookDao.updateBooks(books);
    }
}



