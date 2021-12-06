package com.getir.retailbook.order;


import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderCommandService orderCommandService;


    @PostMapping
    public String createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        return orderCommandService.createOrder(orderCreateRequest.getOrderDto());
    }
}
