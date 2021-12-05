package com.getir.retailbook.repository.order;

import com.getir.retailbook.model.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
