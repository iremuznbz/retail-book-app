package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.cache.annotation.Cacheable;

public interface CustomerDao {
    String createCustomer(CustomerDto customerDto);

    @Cacheable
    CustomerDto findCustomerById(String id);
}
