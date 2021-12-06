package com.getir.retailbook.order.dto;

import java.io.Serializable;
import java.util.List;

public class OrderListResponse implements Serializable {
    private List<OrderDto> orderList;

    public OrderListResponse(List<OrderDto> orderDtoList) {
        orderList = orderDtoList;
    }

    public List<OrderDto> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDto> orderList) {
        this.orderList = orderList;
    }

}
