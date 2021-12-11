package com.getir.retailbook.book;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.order.dto.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class BookDaoTest {

    private BookDaoImpl bookDao;
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        bookRepository = Mockito.mock(BookRepository.class);
        BookMapper bookMapper = new BookMapper();
        bookDao = new BookDaoImpl(bookRepository, bookMapper);

    }

    @Test
    void createBook_IfBookDoesExist_ThenThrowsException() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId("61b2847bef63d6130a1cea36");
        Optional<BookEntity> t = Optional.of(bookEntity);

        Mockito.when(bookRepository.findByName(Mockito.anyString())).thenReturn(t);
        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(bookEntity);

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            BookDto book = bookDto("61b2847bef63d6130a1cea36", "Balikci ve oglu", new BigDecimal(12.50), 1, "Zulfu Livaneli");
            bookDao.createBook(book);
        });

        String expectedMessage = "Book cannot be created with same name.";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(bookRepository).findByName("Balikci ve oglu");
    }

    @Test
    void createBook_IfBookDoesNotExist_ThenCreateBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId("61b2847bef63d6130a1cea36");

        Optional<BookEntity> t = Optional.empty();
        Mockito.when(bookRepository.findByName("Balikci ve oglu")).thenReturn(t);
        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(bookEntity);

        BookDto book = bookDto("61b2847bef63d6130a1cea36", "Balikci ve oglu", new BigDecimal(12.50), 1, "Zulfu Livaneli");
        String id = bookDao.createBook(book);

        assertEquals("61b2847bef63d6130a1cea36",id);
        verify(bookRepository).findByName("Balikci ve oglu");
    }

    @Test
    void findById_IfBookDoesExist_ThenReturnsBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId("61b2847bef63d6130a1cea36");

        Optional<BookEntity> t = Optional.of(bookEntity);
        Mockito.when(bookRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(t);

        BookDto bookDto = bookDao.findById("61b2847bef63d6130a1cea36");

        assertEquals("61b2847bef63d6130a1cea36", bookDto.getId());
        verify(bookRepository).findById("61b2847bef63d6130a1cea36");
    }

    @Test
    void findById_IfBookDoesNotExist_ThenThrowsException() {
        Optional<BookEntity> t = Optional.empty();
        Mockito.when(bookRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(t);
        AtomicReference<BookDto> bookDto = null;

        BusinessException exception = assertThrows(BusinessException.class, () -> {
             bookDto.set(bookDao.findById("61b2847bef63d6130a1cea36"));
        });

        String expectedMessage = "Book not found.";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(bookRepository).findById("61b2847bef63d6130a1cea36");

    }

    @Test
    void updateBookStock_IfBookDoesNotExist_ThenThrowsException(){
        Optional<BookEntity> t = Optional.empty();
        Mockito.when(bookRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(t);

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            bookDao.updateBookStock("61b2847bef63d6130a1cea36",5);
        });

        String expectedMessage = "Book not found.";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(bookRepository).findById("61b2847bef63d6130a1cea36");

    }

    @Test
    void updateBooks_IfBookDtoHasElements_ThenUpdates(){
        List<BookDto> list = new ArrayList<>();
        list.add(bookDto("61b2847bef63d6130a1cea36", "Balikci ve oglu", new BigDecimal(12.50), 1, "Zulfu Livaneli"));
        list.add(bookDto("61b2497bef63d6130a1cea37", "Körlük", new BigDecimal(26.40), 1, "José Saramago"));

        bookDao.updateBooks(list);

        verify(bookRepository).saveAll(Mockito.anyCollection());

    }

    @Test
    void findAllBooks_IfBooksFound_ThenReturnBookDtos(){
        List<String> ids = Arrays.asList("61b2847bef63d6130a1cea36","61b2497bef63d6130a1cea37");
        Mockito.when(bookRepository.findAllByIdAndQuantityIsGreaterThanZero(ids)).thenReturn(Arrays.asList(createEntity("61b2847bef63d6130a1cea36"),createEntity("61b2497bef63d6130a1cea37")));


        List<Item> list = new ArrayList<>();
        list.add(createItem("61b2847bef63d6130a1cea36",4, new BigDecimal(12.50)));
        list.add(createItem("61b2497bef63d6130a1cea37",2, new BigDecimal(26.50)));

        List<BookDto> bookDtos = bookDao.findAllBooks(list);

        assertEquals(2,bookDtos.size());
        verify(bookRepository).findAllByIdAndQuantityIsGreaterThanZero(ids);

    }

    private BookEntity createEntity(String id) {
        BookEntity entity = new BookEntity();
        entity.setId(id);
        return entity;
    }

    private Item createItem(String id, int quantity, BigDecimal amount) {
        return new Item(id,quantity,amount);
    }

    @Test
    void updateBookStock_IfBookDoesExist_ThenUpdates(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId("61b2847bef63d6130a1cea36");

        Optional<BookEntity> t = Optional.of(bookEntity);
        Mockito.when(bookRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(t);

        bookDao.updateBookStock("61b2847bef63d6130a1cea36",5);

        verify(bookRepository).findById("61b2847bef63d6130a1cea36");
        verify(bookRepository).save(bookEntity);

    }

    private BookDto bookDto(String id, String name, BigDecimal amount, Integer quantity, String author) {
        BookDto dto = new BookDto();
        dto.setId(id);
        dto.setName(name);
        dto.setAmount(amount);
        dto.setQuantity(quantity);
        dto.setAuthor(author);
        return dto;
    }
}
