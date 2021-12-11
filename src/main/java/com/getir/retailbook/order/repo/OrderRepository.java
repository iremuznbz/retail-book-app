package com.getir.retailbook.order.repo;

import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.statistics.OrderStatisticDto;
import org.bson.Document;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Aggregation( pipeline = {
            "    $match" +
            "    { 'customer._id': ObjectId('?0') } " +
            "    $unwind" +
            "    { path: '$items' }," +
            "    $group" +
            "    {" +
            "        _id:  { month: {$month: '$createdAt'}}," +
            "        totalAmount: { $push:  '$items.totalAmount'}," +
            "        totalOrderCount: {$sum : 1}," +
            "        totalBookCount: {$sum: '$items.quantity'}" +
            "    }," +
            "    $project" +
            "    {" +
            "            totalAmount: '$totalAmount'," +
            "            totalOrderCount: '$totalOrderCount'," +
            "            totalBookCount: '$totalBookCount'," +
            "            month: '$_id'," +
            "    }"})
    List<OrderStatisticDto> getCustomerStatisticsById(String customerId);

}
