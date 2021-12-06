package com.getir.retailbook.book;

import com.getir.retailbook.book.dto.BookDto;
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
        BookEntity b = (BookEntity) bookMapper.mapToEntity(bookDto);
        return bookRepository.save(b).getId();
    }
}
