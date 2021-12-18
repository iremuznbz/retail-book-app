package com.getir.retailbook.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.retailbook.book.dto.BookCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", password = "admin")   //DefaultUser with username "user", password "password", and a single GrantedAuthority named "ROLE_USER"
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createBook_IfQuantityIsNegative_Returns400Error() throws Exception {
        BookCreateRequest book = new BookCreateRequest();
        book.setName("abc");
        book.setAuthor("author");
        book.setAmount(new BigDecimal("12.90"));
        book.setQuantity(-12);

        mockMvc.perform(post("/book", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createBook_IfNameIsNull_Returns400Error() throws Exception {
        BookCreateRequest book = new BookCreateRequest();
        book.setAuthor("author");
        book.setAmount(new BigDecimal("12.90"));
        book.setQuantity(12);

        mockMvc.perform(post("/book", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createBook_IfAuthorIsNull_Returns400Error() throws Exception {
        BookCreateRequest book = new BookCreateRequest();
        book.setName("name");
        book.setAmount(new BigDecimal("12.90"));
        book.setQuantity(12);

        mockMvc.perform(post("/book", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createBook_IfAmountIsNegative_Returns400Error() throws Exception {
        BookCreateRequest book = new BookCreateRequest();
        book.setName("name");
        book.setAuthor("author");
        book.setAmount(new BigDecimal("-12.90"));
        book.setQuantity(12);

        mockMvc.perform(post("/book", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateBook_IfBookIdIsNull_Returns400Error() throws Exception {
        BookUpdateRequest book = new BookUpdateRequest();
        book.setQuantity(12);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/book", 2)
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateBook_IfQuantityIsNull_Returns400Error() throws Exception {
        BookUpdateRequest book = new BookUpdateRequest();
        book.setBookId("61b2847bef63d6130a1cea36");
        book.setQuantity(-12);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/book", 2)
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
