package com.getir.retailbook.order.repo;

import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.statistics.OrderStatisticDto;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Aggregation(
            "    $match" +
            "    { customerId : ?0 }," +
            "    $unwind" +
            "    { path: '$items' }," +
            "    $group" +
            "    {" +
            "        _id:  { $month: '$createdAt'}," +
            "        totalAmount: { $push:  '$amount' }," +
            "        totalOrderCount: {$sum : 1}," +
            "        totalBookCount: {$sum: '$items.quantity'}" +
            "    }," +
            "    $project" +
            "    {" +
            "        _id:0," +
            "                totalAmount: '$totalAmount'," +
            "            totalOrderCount: '$totalOrderCount'," +
            "            totalBookCount: '$totalBookCount'," +
            "            month: '$_id'," +
            "    }")
    List<OrderStatisticDto> getCustomerStatisticsById(String customerId);

}
