package com.getir.retailbook.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<BookEntity, String> {

    @Query("{ '_id' : {'$in' : ?0 } , 'quantity' : { $gt: 0 } }")
    List<BookEntity> findAllByIdAndQuantityIsGreaterThanZero(List<String> ids);
}
