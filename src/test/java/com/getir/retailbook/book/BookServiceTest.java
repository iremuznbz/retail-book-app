package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.book.service.BookCommandServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookServiceTest {

    private BookDao bookDao;
    private BookCommandServiceImpl bookCommandService;

    @BeforeEach
    public void setup() {
        bookDao = Mockito.mock(BookDao.class);
        bookCommandService = new BookCommandServiceImpl(bookDao);
        Mockito.when(bookDao.createBook(Mockito.any(BookDto.class))).thenReturn("61b2847bef63d6130a1cea36");
    }


    @Test
    public void createBook_IfBookDtoHasParams_ThenCreateBook() {
        BookDto bookDto = new BookDto();
        String id = bookCommandService.createBook(bookDto);
        assertEquals("61b2847bef63d6130a1cea36", id);
    }

}
