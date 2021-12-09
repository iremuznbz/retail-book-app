package com.getir.retailbook.order.repo;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.order.OrderMapper;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.statistics.OrderStatisticDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDaoImpl(OrderRepository orderRepository, OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto findOrderById(String id) {
        Optional<OrderEntity> o = orderRepository.findById(id);
        if(o.isPresent()) return (OrderDto) orderMapper.mapToDto(o.get());
        else throw new BusinessException("O004", "Order does not exist");

    }

    @Override
    public List<OrderDto> listOrdersByInterval(LocalDateTime startDate, LocalDateTime endDate) {
        List<OrderEntity> orderList = orderRepository.findByCreatedAtBetween(startDate, endDate);
        List<OrderDto> dtoList = new ArrayList<>();
        for(OrderEntity o : orderList)
            dtoList.add((OrderDto) orderMapper.mapToDto(o));
        return dtoList;
    }

    @Override
    public List<OrderStatisticDto> getCustomerStatisticsById(String customerId) {
        return orderRepository.getCustomerStatisticsById(customerId);
    }
}
