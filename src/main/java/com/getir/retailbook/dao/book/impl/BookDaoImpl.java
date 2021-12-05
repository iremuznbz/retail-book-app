package com.getir.retailbook.dao.book.impl;

import com.getir.retailbook.dao.book.BookDao;
import com.getir.retailbook.dto.book.BookDto;
import com.getir.retailbook.model.book.Book;
import com.getir.retailbook.repository.book.BookRepository;
import com.getir.retailbook.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public String createBook(BookDto bookDto) {
        Book b = (Book) bookMapper.mapToEntity(bookDto);
        return bookRepository.save(b).getId();
    }
}
