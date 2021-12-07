package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookCreateRequest;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements EntityMapper {

    @Override
    public Object mapToEntity(Object dto) {
        BookDto bookDto = (BookDto) dto;
        BookEntity b = new BookEntity();
        b.setId(bookDto.getId());
        b.setAuthor(bookDto.getAuthor());
        b.setName(bookDto.getName());
        b.setStock(bookDto.getStock());
        return b;
    }

    @Override
    public Object mapToDto(Object entity) {
        BookEntity b = (BookEntity) entity;
        BookDto bookDto = new BookDto();
        bookDto.setId(b.getId());
        bookDto.setAuthor(b.getAuthor());
        bookDto.setName(b.getName());
        bookDto.setStock(b.getStock());
        return bookDto;
    }

    public BookDto fromRequestToDto(BookCreateRequest request) {
        BookDto b = new BookDto();
        b.setName(request.getName());
        b.setAuthor(request.getAuthor());
        b.setStock(request.getStock());
        return b;
    }
}
