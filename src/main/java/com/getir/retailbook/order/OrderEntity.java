package com.getir.retailbook.order;

import com.getir.retailbook.BaseEntity;
import com.getir.retailbook.book.BookEntity;
import com.getir.retailbook.customer.CustomerEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document("order")
public class OrderEntity extends BaseEntity {
    @Id
    private String id;

    @NotNull
    private CustomerEntity customer;

    @NotEmpty
    private List<BookEntity> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
