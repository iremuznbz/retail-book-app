package com.getir.retailbook.order;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.repo.OrderDao;
import com.getir.retailbook.order.repo.OrderDaoImpl;
import com.getir.retailbook.order.repo.OrderRepository;
import com.getir.retailbook.statistics.OrderStatisticDto;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.getir.retailbook.order.OrderTestFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class OrderDaoTest {

    private OrderDao orderDao;
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;


    @BeforeEach
    public void setUp(){
        orderRepository = Mockito.mock(OrderRepository.class);
        orderMapper = Mockito.mock(OrderMapper.class);// new OrderMapper(customerQueryService, bookQueryService, customerMapper, bookMapper);
        orderDao = new OrderDaoImpl(orderRepository, orderMapper);
        Item i = createItem("61bce5a81e74a322432c85ed", 5, 12.90);
        Item i2 = createItem("61bce6101e74a322432c85ef", 15, 24.90);
        Mockito.when(orderMapper.mapToDto(Mockito.any(OrderEntity.class))).thenReturn(createOrderDto(Arrays.asList(i,i2)));
        Mockito.when(orderMapper.mapToEntity(Mockito.any(OrderEntity.class))).thenReturn(createOrderEntity());
    }

    @Test
    public void findOrderById_IfOrderDoesNotExist_ThrowsException(){
        Optional<OrderEntity> order = Optional.empty();
        Mockito.when(orderRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(order);

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            orderDao.findOrderById("61b2847bef63d6130a1cea36");
        });

        String expectedMessage = "Order does not exist";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(orderRepository).findById("61b2847bef63d6130a1cea36");
    }

    @Test
    public void findOrderById_IfOrderExist_ThenReturnsDto(){
        Optional<OrderEntity> order = Optional.of(createOrderEntity());
        Mockito.when(orderRepository.findById("61b2847bef63d6130a1cea36")).thenReturn(order);

       OrderDto dto =  orderDao.findOrderById("61b2847bef63d6130a1cea36");
       assertNotNull(dto);
    }

    @Test
    public void listOrdersByInterval_IfStartEndDateExist_ThenReturnsList(){
        Mockito.when(orderRepository.findByCreatedAtBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(createOrderEntityList());
        List<OrderDto> list = orderDao.listOrdersByInterval(LocalDateTime.of(2021, 11, 5, 14, 0, 0), LocalDateTime.of(2021, 10, 5, 13, 30, 0));

        assertTrue(list.size() > 0);
        verify(orderRepository).findByCreatedAtBetween(Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class));
    }

    @Test
    public void getCustomerStatisticsById_IfOrderIdExist_ThenReturnsList(){
        Document rawResult = new Document();
        List<OrderStatisticDto> mappedResults = createOrderStatisticList();
        AggregationResults<OrderStatisticDto> orderStatistic = new AggregationResults<>(mappedResults, rawResult);
        Mockito.when(orderRepository.getCustomerStatisticsById("61b2847bef63d6130a1cea36")).thenReturn(orderStatistic);

        List<OrderStatisticDto> list = orderDao.getCustomerStatisticsById("61b2847bef63d6130a1cea36");

        assertTrue(list.size() > 0);
        verify(orderRepository).getCustomerStatisticsById("61b2847bef63d6130a1cea36");
    }

    @Test
    public void findOrderListByCustomerID_IfCustomerDoesExist_ReturnOrderList(){
        Mockito.when(orderRepository.findOrderEntitiesByCustomerId("61b2847bef63d6130a1cea36")).thenReturn(createOrderEntityList());

        List<OrderDto> list = orderDao.findOrderListByCustomerID("61b2847bef63d6130a1cea36");
        assertTrue(list.size() > 0);
        verify(orderRepository).findOrderEntitiesByCustomerId("61b2847bef63d6130a1cea36");

    }



}
