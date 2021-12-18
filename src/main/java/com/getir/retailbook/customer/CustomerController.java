package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerCreateRequest;
import com.getir.retailbook.customer.dto.CustomerOrderListRequest;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.dto.OrderListResponse;
import com.getir.retailbook.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerCommandService customerCommandService;

    @Autowired
    private OrderQueryService orderQueryService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public String createCustomer(@RequestBody @Valid CustomerCreateRequest customerCreateRequest){
        return customerCommandService.createCustomer(customerMapper.fromCreateRequestToDto(customerCreateRequest));
    }


    @GetMapping("/orders/{id}")
    public OrderListResponse getCustomerOrders(@PathVariable String id ){
        List<OrderDto> l = orderQueryService.findOrderListByCustomerID(id);
        OrderListResponse resp= new OrderListResponse();
        resp.setOrderList(l);
        return resp;
    }
}
