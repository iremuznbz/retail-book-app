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
        b.setQuantity(bookDto.getQuantity());
        return b;
    }

    @Override
    public Object mapToDto(Object entity) {
        BookEntity b = (BookEntity) entity;
        BookDto bookDto = new BookDto();
        bookDto.setId(b.getId());
        bookDto.setAuthor(b.getAuthor());
        bookDto.setName(b.getName());
        bookDto.setQuantity(b.getQuantity());
        return bookDto;
    }

    public BookDto fromRequestToDto(BookCreateRequest request) {
        BookDto b = new BookDto();
        b.setName(request.getName());
        b.setAuthor(request.getAuthor());
        b.setQuantity(request.getQuantity());
        return b;
    }


}
