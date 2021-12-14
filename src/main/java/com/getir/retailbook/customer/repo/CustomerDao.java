package com.getir.retailbook.customer.repo;

import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

public interface CustomerDao {
    String createCustomer(CustomerDto customerDto);

    @Cacheable
    CustomerDto findCustomerById(String id);

    Optional<CustomerEntity> findCustomerByEmail(String email);
}
