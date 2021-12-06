package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookCreateRequest;
import com.getir.retailbook.book.service.BookCommandService;
import com.getir.retailbook.book.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String createBook(@RequestBody BookCreateRequest request){
        bookCommandService.createBook(request.getBookDto());
        return null;
    }

}
