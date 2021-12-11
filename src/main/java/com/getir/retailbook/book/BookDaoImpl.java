package com.getir.retailbook.book;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.order.dto.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDaoImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public String createBook(BookDto bookDto) {
        Optional<BookEntity> book = bookRepository.findByName(bookDto.getName());
        if(book.isPresent()) throw new BusinessException("B002","Book cannot be created with same name.");
        BookEntity b = (BookEntity) bookMapper.mapToEntity(bookDto);
        return bookRepository.save(b).getId();
    }

    @Override
    public List<BookDto> findAllBooks(List<Item> books) {
        List<String> ids = new ArrayList<>();
        books.forEach(book -> ids.add(book.getBookId()));

        List<BookEntity> bookEntities =  bookRepository.findAllByIdAndQuantityIsGreaterThanZero(ids);
        List<BookDto> bookDtos = new ArrayList<>();

        for(BookEntity b : bookEntities)
            bookDtos.add((BookDto) bookMapper.mapToDto(b));

        return bookDtos;
    }

    @Override
    public BookDto findById(String bookId) {
        Optional<BookEntity> entity = bookRepository.findById(bookId);
        if(entity.isEmpty()) throw new BusinessException("B001", "Book not found.");
        return (BookDto) bookMapper.mapToDto(entity);
    }

    @Override
    public void updateBooks(List<BookDto> books) {
        List<BookEntity> entities = new ArrayList<>();
        books.forEach(b -> entities.add((BookEntity) bookMapper.mapToEntity(b)));
        bookRepository.saveAll(entities);
    }

    @Override
    public void updateBookStock(String id, int quantity) {
        Optional<BookEntity> b = bookRepository.findById(id);
        if(b.isEmpty()) throw new BusinessException("B001", "Book not found.");
        bookRepository.save(b.get());
    }
}
