package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerDto;

public interface CustomerDao {
    String createCustomer(CustomerDto customerDto);

    CustomerDto findCustomerById(String id);
}
