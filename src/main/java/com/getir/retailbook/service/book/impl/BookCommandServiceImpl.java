package com.getir.retailbook.service.book.impl;

import com.getir.retailbook.dao.book.BookDao;
import com.getir.retailbook.dto.book.BookDto;
import com.getir.retailbook.service.book.BookCommandService;
import com.getir.retailbook.service.book.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BookCommandServiceImpl implements BookCommandService {

    @Autowired
    private BookDao bookDao;

    @Override
    public String createBook(BookDto bookDto) {
       return bookDao.createBook(bookDto);
    }
}



