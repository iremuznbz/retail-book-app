package com.getir.retailbook.customer.service;


import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.order.dto.OrderDto;

import java.util.List;

public interface CustomerQueryService {
    CustomerDto findCustomerById(String id);
}
