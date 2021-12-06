package com.getir.retailbook.order.dto;

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
