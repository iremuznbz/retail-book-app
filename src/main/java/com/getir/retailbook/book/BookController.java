package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookCreateRequest;
import com.getir.retailbook.book.service.BookCommandService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookCommandService bookCommandService;
    private final BookMapper bookMapper;

    public BookController(BookCommandService bookCommandService, BookMapper bookMapper) {
        this.bookCommandService = bookCommandService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public String createBook(@RequestBody @Valid BookCreateRequest request){
        return bookCommandService.createBook(bookMapper.fromRequestToDto(request));
    }

    @PutMapping
    public void updateBookStock(@RequestBody @Valid BookUpdateRequest request){
        bookCommandService.updateBookStock(request.getBookId(), request.getQuantity());
    }

}
