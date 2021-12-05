package com.getir.retailbook.controller.customer;

import com.getir.retailbook.request.CustomerCreateRequest;
import com.getir.retailbook.request.CustomerOrderListRequest;
import com.getir.retailbook.service.customer.CustomerCommandService;
import com.getir.retailbook.service.customer.CustomerQueryService;
import com.getir.retailbook.dto.order.OrderDto;
import com.getir.retailbook.response.OrderListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerCommandService customerCommandService;

    @Autowired
    private CustomerQueryService customerQueryService;

    @PostMapping
    public String createCustomer(@RequestBody CustomerCreateRequest customerCreateRequest){
        return customerCommandService.createCustomer(customerCreateRequest.getCustomerDto());
    }


    @GetMapping("/orders/{id}")
    public OrderListResponse getCustomerOrders(@RequestParam CustomerOrderListRequest customerOrderListRequest){
        List<OrderDto> l = customerQueryService.findOrderListByCustomerID(customerOrderListRequest.toCustomerId());
        return new OrderListResponse(l);
    }
}
