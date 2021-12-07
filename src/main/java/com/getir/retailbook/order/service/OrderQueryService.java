package com.getir.retailbook.order.service;

import com.getir.retailbook.order.dto.OrderDto;

import java.time.LocalDate;
import java.util.List;

public interface OrderQueryService {
    OrderDto findOrderById(String id);

    List<OrderDto> listOrdersByInterval(LocalDate startDate, LocalDate endDate);
}
