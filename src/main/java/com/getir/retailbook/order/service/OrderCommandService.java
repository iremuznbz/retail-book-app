package com.getir.retailbook.order.service;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.order.dto.OrderDto;

public interface OrderCommandService {
    String createOrder(OrderDto orderDto) throws BusinessException;
}
