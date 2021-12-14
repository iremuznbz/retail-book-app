package com.getir.retailbook.customer.service;

import com.getir.retailbook.customer.repo.CustomerDao;
import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final CustomerDao customerDao;

    public CustomerQueryServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public CustomerDto findCustomerById(String id) {
        return customerDao.findCustomerById(id);
    }
}
