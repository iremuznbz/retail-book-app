package com.getir.retailbook.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<BookEntity, String> {

    Optional<BookEntity> findByName(String name);

    @Query("{ '_id' : {'$in' : ?0 } , 'quantity' : { $gt: 0 } }")
    List<BookEntity> findAllByIdAndQuantityIsGreaterThanZero(List<String> ids);
}
