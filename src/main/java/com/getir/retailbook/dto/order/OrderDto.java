package com.getir.retailbook.dto.order;

import com.getir.retailbook.dto.customer.CustomerDto;

public class OrderDto {

    private String id;
    private CustomerDto customerDto;

    public OrderDto( CustomerDto customerDto) {
        this(null, customerDto);
    }

    public OrderDto(String id, CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}

