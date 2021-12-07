package com.getir.retailbook.order;

import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.CustomerMapper;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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
        CustomerEntity c = (CustomerEntity) customerMapper.mapToEntity(customerQueryService.findCustomerById(orderDto.getCustomerid()));
        o.setCustomer(c);
        return o;
    }

    @Override
    public Object mapToDto(Object entity) {
        OrderEntity o = (OrderEntity) entity;
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerid(o.getCustomer().getId());
        orderDto.setBooks(o.getItems());
        return orderDto;
    }

    public OrderDto fromCreateRequestToDto(OrderCreateRequest req) {
        OrderDto dto = new OrderDto();
        dto.setCustomerid(req.getCustomerId());
        dto.setBooks(req.getBooks());
        return dto;
    }

    public OrderListResponse fromDtoListToResponse(List<OrderDto> orderList) {
        OrderListResponse res = new OrderListResponse();
        res.setOrderList(orderList);
        return res;
    }
}
