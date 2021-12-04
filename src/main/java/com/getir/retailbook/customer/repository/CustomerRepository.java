package com.getir.retailbook.customer.repository;

import com.getir.retailbook.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
