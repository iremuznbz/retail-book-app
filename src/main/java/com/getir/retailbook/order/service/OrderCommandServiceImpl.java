package com.getir.retailbook.order.service;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.order.OrderMapper;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.repo.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;
    private final CustomerQueryService customerQueryService;
    private final OrderMapper orderMapper;

    public OrderCommandServiceImpl(OrderRepository orderRepository, CustomerQueryService customerQueryService, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerQueryService = customerQueryService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public String createOrder(OrderDto orderDto) throws BusinessException {
        CustomerDto c = customerQueryService.findCustomerById(orderDto.getCustomerid());
        if(c == null)
            throw new BusinessException("O001", "Cannot create order with non existing customer.");

        OrderEntity order = (OrderEntity) orderMapper.mapToEntity(orderDto);
        return orderRepository.save(order).getId();
    }
}
