package com.getir.retailbook.order;

import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.statistics.OrderStatisticDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderTestFactory {

    public static OrderEntity createOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreatedAt(LocalDateTime.now());
        return orderEntity;
    }

    public static List<OrderEntity> createOrderEntityList() {
        List<OrderEntity> l = new ArrayList<>();
        OrderEntity o = new OrderEntity();
        o.setId("1");
        o.setCreatedAt(LocalDateTime.now());
        l.add(o);
        o = new OrderEntity();
        o.setId("2");
        o.setCreatedAt(LocalDateTime.now());
        l.add(o);
        return l;
    }

    public static OrderDto createOrderDto(List<Item> itemsList) {
        OrderDto dto = new OrderDto();
        List<Item> items = new ArrayList<>();
        items.addAll(itemsList);
        dto.setItems(items);
        dto.setCreatedAt(LocalDate.now());
        dto.setCustomerid("61bce5c81e74a322432c85ee");
        return dto;
    }

    public static Item createItem(String id, int quantity, double amount) {
        return new Item(id, quantity, new BigDecimal(amount));
    }

    public static List<OrderStatisticDto> createOrderStatisticList() {
        List<OrderStatisticDto> l = new ArrayList<>();
        OrderStatisticDto o = new OrderStatisticDto();
        l.add(o);
        return l;
    }
}
