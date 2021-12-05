package com.getir.retailbook.service.mapper;

import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.dto.order.OrderDto;
import com.getir.retailbook.model.customer.Customer;
import com.getir.retailbook.model.order.Order;
import com.getir.retailbook.service.customer.CustomerQueryService;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements EntityMapper {
    @Autowired
    private CustomerQueryService customerQueryService;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Object mapToEntity(Object dto) {
        OrderDto orderDto = (OrderDto) dto;
        Order o = new Order();
        Customer c = (Customer) customerMapper.mapToEntity(customerQueryService.findCustomerById(orderDto.getCustomerDto().getId()));
        o.setCustomer(c);
        return o;
    }

    @Override
    public Object mapToDto(Object entity) {
        Order o = (Order) entity;
        OrderDto orderDto = new OrderDto((CustomerDto) customerMapper.mapToDto(((Order) entity).getCustomer()));
        return orderDto;
    }

}
