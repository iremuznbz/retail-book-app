package com.getir.retailbook.order.repo;

import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.statistics.OrderStatisticDto;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<OrderEntity> findOrderEntitiesByCustomerId(String customerId);

    @Aggregation( pipeline = {"{$match: { customerId: '?0' }}", "{$unwind: { path: '$items'}}", "{\n" +
            "    $group: {\n" +
            "        _id: {\n" +
            "            $month: '$createdAt'\n" +
            "        },\n" +
            "        totalAmount: {\n" +
            "            $sum: {\n" +
            "                $toDecimal: '$items.totalAmount'\n" +
            "            }\n" +
            "        },\n" +
            "        totalOrderCount: {\n" +
            "            $sum: 1\n" +
            "        },\n" +
            "        totalBookCount: {\n" +
            "            $sum: '$items.quantity'\n" +
            "        }\n" +
            "    }\n" +
            "}, {\n" +
            "    $project: {\n" +
            "        totalAmount: '$totalAmount',\n" +
            "        totalOrderCount: '$totalOrderCount',\n" +
            "        totalBookCount: '$totalBookCount',\n" +
            "        month: '$_id'\n" +
            "    }\n" +
            "}"})
    AggregationResults<OrderStatisticDto> getCustomerStatisticsById(String customerId);

}
