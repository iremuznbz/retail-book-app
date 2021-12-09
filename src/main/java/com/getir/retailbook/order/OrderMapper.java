package com.getir.retailbook.order;

import com.getir.retailbook.book.BookMapper;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.book.service.BookQueryService;
import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.CustomerMapper;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class OrderMapper implements EntityMapper {
    private final CustomerQueryService customerQueryService;
    private final BookQueryService bookQueryService;
    private final CustomerMapper customerMapper;
    private final BookMapper bookMapper;

    public OrderMapper(CustomerQueryService customerQueryService, BookQueryService bookQueryService, CustomerMapper customerMapper, BookMapper bookMapper) {
        this.customerQueryService = customerQueryService;
        this.bookQueryService = bookQueryService;
        this.customerMapper = customerMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public Object mapToEntity(Object dto) {
        OrderDto orderDto = (OrderDto) dto;
        OrderEntity o = new OrderEntity();
        CustomerEntity c = (CustomerEntity) customerMapper.mapToEntity(customerQueryService.findCustomerById(orderDto.getCustomerid()));
        o.setCustomer(c);
        List<Item> items = new ArrayList<>();
        for(Item item : ((OrderDto) dto).getItems()){
            BookDto bookDto = bookQueryService.findById(item.getBookId());
            Item i = new Item(bookDto.getId(),item.getQuantity(), bookDto.getAmount().multiply(new BigDecimal(item.getQuantity())));
            items.add(i);
        }
        o.setItems(items);
        return o;
    }

    @Override
    public Object mapToDto(Object entity) {
        OrderEntity o = (OrderEntity) entity;
        OrderDto orderDto = new OrderDto();
        orderDto.setId(o.getId());
        orderDto.setCustomerid(o.getCustomer().getId());
        orderDto.setItems(((OrderEntity) entity).getItems());
        orderDto.setCreatedAt(((OrderEntity) entity).getCreatedAt().toLocalDate());
        return orderDto;
    }

    public OrderDto fromCreateRequestToDto(OrderCreateRequest req) {
        OrderDto dto = new OrderDto();
        dto.setCustomerid(req.getCustomerId());
        dto.setItems(req.getBooks());
        return dto;
    }

    public OrderListResponse fromDtoListToResponse(List<OrderDto> orderList) {
        OrderListResponse res = new OrderListResponse();
        res.setOrderList(orderList);
        return res;
    }
}
