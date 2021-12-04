package com.getir.retailbook.customer.controller;

import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.customer.service.CustomerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerCommandService customerCommandService;

    @Autowired
    private CustomerQueryService customerQueryService;

    @PostMapping
    public String createCustomer(@RequestBody CustomerDto customerDto){
        return customerCommandService.createCustomer(customerDto);
    }

}
