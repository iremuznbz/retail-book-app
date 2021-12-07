package com.getir.retailbook.customer.service;

import com.getir.retailbook.customer.repo.CustomerDaoImpl;
import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

    @Autowired
    private CustomerDaoImpl customerDao;


    @Override
    public String createCustomer(CustomerDto customerDto) {
        return customerDao.createCustomer(customerDto);
    }
}
