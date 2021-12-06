package com.getir.retailbook.order.service;

import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.order.OrderMapper;
import com.getir.retailbook.order.OrderRepository;
import com.getir.retailbook.order.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public String createOrder(OrderDto orderDto) {
        OrderEntity order = (OrderEntity) orderMapper.mapToEntity(orderDto);
        return orderRepository.save(order).getId();
    }
}
