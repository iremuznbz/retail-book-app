package com.getir.retailbook.service.impl;

import com.getir.retailbook.dto.CustomerDto;
import com.getir.retailbook.model.Customer;
import com.getir.retailbook.repository.CustomerRepository;
import com.getir.retailbook.service.CustomerService;
import com.getir.retailbook.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer createCustomer(CustomerDto customerDto) {
        Customer cust = (Customer) customerMapper.map(customerDto);
        return customerRepository.save(cust).getId();
    }

}
