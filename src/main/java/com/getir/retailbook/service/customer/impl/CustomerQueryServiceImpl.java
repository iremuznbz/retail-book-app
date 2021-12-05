package com.getir.retailbook.service.customer.impl;

import com.getir.retailbook.dao.customer.CustomerDao;
import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.dto.order.OrderDto;
import com.getir.retailbook.service.customer.CustomerQueryService;
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
