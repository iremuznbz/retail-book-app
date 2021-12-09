package com.getir.retailbook.statistics;

import com.getir.retailbook.order.repo.OrderDao;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderDao orderDao;

    public StatisticsServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public StatisticsResponse getCustomerStatisticsById(String customerId) {
        orderDao.getCustomerStatisticsById(customerId);
        return null;
    }
}
