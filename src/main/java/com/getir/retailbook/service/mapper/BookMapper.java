package com.getir.retailbook.service.mapper;

import com.getir.retailbook.dto.book.BookDto;
import com.getir.retailbook.model.book.Book;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements EntityMapper {

    @Override
    public Object mapToEntity(Object dto) {
        BookDto bookDto = (BookDto) dto;
        Book b = new Book();
        b.setId(bookDto.getId());
        b.setAuthor(bookDto.getAuthor());
        b.setName(bookDto.getName());
        b.setStock(bookDto.getStock());
        return b;
    }

    @Override
    public Object mapToDto(Object entity) {
        Book b = (Book) entity;
        BookDto bookDto = new BookDto();
        bookDto.setId(b.getId());
        bookDto.setAuthor(b.getAuthor());
        bookDto.setName(b.getName());
        bookDto.setStock(b.getStock());
        return bookDto;
    }
}
