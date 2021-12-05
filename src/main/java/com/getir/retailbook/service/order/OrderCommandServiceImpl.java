package com.getir.retailbook.service.order;

import com.getir.retailbook.dto.order.OrderDto;
import com.getir.retailbook.model.order.Order;
import com.getir.retailbook.repository.order.OrderRepository;
import com.getir.retailbook.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String createOrder(OrderDto orderDto) {
        Order order = (Order) orderMapper.mapToEntity(orderDto);
        return orderRepository.save(order).getId();
    }
}
