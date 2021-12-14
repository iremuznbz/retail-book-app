package com.getir.retailbook.customer.repo;

import com.getir.retailbook.customer.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByEmail(String email);
}
