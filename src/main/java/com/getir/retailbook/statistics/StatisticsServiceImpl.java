package com.getir.retailbook.statistics;

import com.getir.retailbook.order.repo.OrderDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderDao orderDao;

    public StatisticsServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public StatisticsResponse getCustomerStatisticsById(String customerId) {
        List<OrderStatisticDto> orderStats = orderDao.getCustomerStatisticsById(customerId);
        StatisticsResponse res = new StatisticsResponse();
        res.setStatistics(orderStats);
        return res;
    }
}
