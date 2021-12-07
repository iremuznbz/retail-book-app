package com.getir.retailbook.customer.service;

import com.getir.retailbook.customer.repo.CustomerDao;
import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.order.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

    @Autowired
    private CustomerDao customerDao;

    @Override // TODO: Find mi get mi olmali
    public List<OrderDto> findOrderListByCustomerID(String id) {
        return null;
    }

    @Override
    public CustomerDto findCustomerById(String id) {
        return customerDao.findCustomerById(id);
    }
}
