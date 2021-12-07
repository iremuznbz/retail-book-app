package com.getir.retailbook.order.service;

import com.getir.retailbook.order.repo.OrderDao;
import com.getir.retailbook.order.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderQueryServiceImpl implements OrderQueryService{

    private final OrderDao orderDao;

    public OrderQueryServiceImpl(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Override
    public OrderDto findOrderById(String id) {
       return orderDao.findOrderById(id);
    }

    @Override
    public List<OrderDto> listOrdersByInterval(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 0, 0);
        return orderDao.listOrdersByInterval(startDateTime, endDateTime);
    }
}
