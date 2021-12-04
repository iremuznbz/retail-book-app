package com.getir.retailbook.customer.service.impl;

import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.model.Customer;
import com.getir.retailbook.customer.repository.CustomerRepository;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.customer.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerDto customerDto) {
        Customer cust = (Customer) customerMapper.map(customerDto);
        return customerRepository.save(cust).getId();
    }
}
