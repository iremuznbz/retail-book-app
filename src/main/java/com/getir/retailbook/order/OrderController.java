package com.getir.retailbook.order;


import com.getir.retailbook.BusinessException;
import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import com.getir.retailbook.order.service.OrderCommandService;
import com.getir.retailbook.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderCommandService orderCommandService;

    @Autowired
    private OrderQueryService orderQueryService;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping // TODO: atomicity order yaratbook stock update et
    public String createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        try {
            return orderCommandService.createOrder(orderMapper.fromCreateRequestToDto(orderCreateRequest));
        } catch (BusinessException e) {
            e.printStackTrace();
            return null;
        }
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
