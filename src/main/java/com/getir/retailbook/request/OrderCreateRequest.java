package com.getir.retailbook.request;

import com.getir.retailbook.dto.order.OrderDto;

import javax.validation.constraints.NotNull;

public class OrderCreateRequest {

    @NotNull
    private OrderDto orderDto;

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }
}
