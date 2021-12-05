package com.getir.retailbook.service.order;

import com.getir.retailbook.dto.order.OrderDto;

public interface OrderCommandService {
    String createOrder(OrderDto orderDto);
}
