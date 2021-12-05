package com.getir.retailbook.service.customer;


import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.dto.order.OrderDto;

import java.util.List;

public interface CustomerQueryService {
    List<OrderDto> findOrderListByCustomerID(String id);
    CustomerDto findCustomerById(String id);
}
