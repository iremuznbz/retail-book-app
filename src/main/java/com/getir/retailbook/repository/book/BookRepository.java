package com.getir.retailbook.repository.book;

import com.getir.retailbook.model.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
