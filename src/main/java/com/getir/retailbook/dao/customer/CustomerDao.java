package com.getir.retailbook.dao.customer;

import com.getir.retailbook.dto.customer.CustomerDto;

public interface CustomerDao {
    String createCustomer(CustomerDto customerDto);

    CustomerDto findCustomerById(String id);
}
