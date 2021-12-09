package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookCreateRequest;
import com.getir.retailbook.book.service.BookCommandService;
import com.getir.retailbook.book.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookCommandService bookCommandService;

    @Autowired
    private BookQueryService bookQueryService;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping
    public String createBook(@RequestBody BookCreateRequest request){
        return bookCommandService.createBook(bookMapper.fromRequestToDto(request));
    }

    @PutMapping
    public void updateBookStock(@RequestBody BookUpdateRequest request){
        bookCommandService.updateBookStock(request.getBookId(), request.getQuantity());
    }

}
