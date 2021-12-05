package com.getir.retailbook.controller.book;

import com.getir.retailbook.request.BookCreateRequest;
import com.getir.retailbook.service.book.BookCommandService;
import com.getir.retailbook.service.book.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookCommandService bookCommandService;

    @Autowired
    private BookQueryService bookQueryService;

    @PostMapping
    public String createBook(BookCreateRequest request){
        bookCommandService.createBook(request.getBookDto());
        return null;
    }

}
