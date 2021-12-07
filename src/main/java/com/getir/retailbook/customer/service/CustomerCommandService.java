package com.getir.retailbook.customer.service;

import com.getir.retailbook.customer.dto.CustomerDto;

public interface CustomerCommandService {
    String createCustomer(CustomerDto customerDto);

}
