package com.getir.retailbook.order.repo;

import com.getir.retailbook.order.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findByCreatedOnBetween(LocalDateTime startDate, LocalDateTime endDate);
}
