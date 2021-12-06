package com.getir.retailbook.order;

import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.CustomerMapper;
import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.dto.OrderDto;
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
        OrderEntity o = new OrderEntity();
        CustomerEntity c = (CustomerEntity) customerMapper.mapToEntity(customerQueryService.findCustomerById(orderDto.getCustomerDto().getId()));
        o.setCustomer(c);
        return o;
    }

    @Override
    public Object mapToDto(Object entity) {
        OrderEntity o = (OrderEntity) entity;
        OrderDto orderDto = new OrderDto((CustomerDto) customerMapper.mapToDto(((OrderEntity) entity).getCustomer()));
        return orderDto;
    }

}
