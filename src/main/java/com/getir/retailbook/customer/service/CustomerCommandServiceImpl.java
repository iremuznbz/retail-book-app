package com.getir.retailbook.customer.service;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.repo.CustomerDaoImpl;
import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CustomerDaoImpl customerDao;

    public CustomerCommandServiceImpl(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public String createCustomer(CustomerDto customerDto) {
        Optional<CustomerEntity> c = customerDao.findCustomerByEmail(customerDto.getEmail());
        if (c.isPresent())
            throw new BusinessException("C002", "Email has been used before.");

        return customerDao.createCustomer(customerDto);
    }
}
