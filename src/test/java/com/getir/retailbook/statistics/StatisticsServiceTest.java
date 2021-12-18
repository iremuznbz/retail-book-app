package com.getir.retailbook.statistics;

import com.getir.retailbook.order.repo.OrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class StatisticsServiceTest {

    StatisticsService statisticsService;
    OrderDao orderDao;

    @BeforeEach
    public void setUp() {
        orderDao = mock(OrderDao.class);
        statisticsService = new StatisticsServiceImpl(orderDao);
    }

    @Test
    public void getCustomerStatisticsById_IfCustomerIDGiven_thenReturnsList(){
        Mockito.when(orderDao.getCustomerStatisticsById("61bce5c81e74a322432c85ee")).thenReturn(createOrderStatisticList());
        StatisticsResponse response = statisticsService.getCustomerStatisticsById("61bce5c81e74a322432c85ee");
        assertNotNull(response);
        assertTrue(response.getStatistics().size() == 1);
    }

    private List<OrderStatisticDto> createOrderStatisticList() {
        List<OrderStatisticDto> l = new ArrayList<>();
        OrderStatisticDto dto = new OrderStatisticDto();
        l.add(dto);
        return l;
    }

}
