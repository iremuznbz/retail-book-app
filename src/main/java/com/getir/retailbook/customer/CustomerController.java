package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerCreateRequest;
import com.getir.retailbook.customer.dto.CustomerOrderListRequest;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerCommandService customerCommandService;

    @Autowired
    private CustomerQueryService customerQueryService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public String createCustomer(@RequestBody CustomerCreateRequest customerCreateRequest){
        return customerCommandService.createCustomer(customerMapper.fromCreateRequestToDto(customerCreateRequest));
    }


    @GetMapping("/orders/{id}")
    public OrderListResponse getCustomerOrders(@RequestParam CustomerOrderListRequest customerOrderListRequest){
        List<OrderDto> l = customerQueryService.findOrderListByCustomerID(customerOrderListRequest.toCustomerId());
        return new OrderListResponse(l);
    }
}
