package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookTestFactory {
    public static List<BookDto> createBookDtos(List<BookDto> dtos){
        List<BookDto> l = new ArrayList<>();
        l.addAll(dtos);
        return l;
    }

    public static BookDto createBookDto(String id, String name, int quantity, double amount) {
        BookDto b = new BookDto();
        b.setId(id);
        b.setName(name);
        b.setQuantity(quantity);
        b.setAmount(new BigDecimal(amount));
        return b;
    }
}
