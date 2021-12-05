package com.getir.retailbook.repository.customer;

import com.getir.retailbook.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
