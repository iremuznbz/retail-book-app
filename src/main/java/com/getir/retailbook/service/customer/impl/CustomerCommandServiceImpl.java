package com.getir.retailbook.service.impl.customer;

import com.getir.retailbook.dao.customer.impl.CustomerDaoImpl;
import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.service.customer.CustomerCommandService;
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
