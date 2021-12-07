package com.getir.retailbook.order.repo;

import com.getir.retailbook.order.dto.OrderDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderDao {
    OrderDto findOrderById(String id);

    List<OrderDto> listOrdersByInterval(LocalDateTime startDate, LocalDateTime endDate);
}
