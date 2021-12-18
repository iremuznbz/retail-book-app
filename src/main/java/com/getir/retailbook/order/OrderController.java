package com.getir.retailbook.order;


import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import com.getir.retailbook.order.service.OrderCommandService;
import com.getir.retailbook.order.service.OrderQueryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;
    private final OrderMapper orderMapper;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService, OrderMapper orderMapper) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
        this.orderMapper = orderMapper;
    }


    @PostMapping
    public String createOrder(@RequestBody @Valid OrderCreateRequest orderCreateRequest){
            return orderCommandService.createOrder(orderMapper.fromCreateRequestToDto(orderCreateRequest));
    }

    @GetMapping("/{orderId}")
    public OrderDto findOrderById(@PathVariable  String orderId){
        return orderQueryService.findOrderById(orderId);
    }

    @GetMapping("/search")
    public OrderListResponse listOrdersByInterval(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<OrderDto> orderList = orderQueryService.listOrdersByInterval(startDate, endDate);
        return orderMapper.fromDtoListToResponse(orderList);
    }
}
