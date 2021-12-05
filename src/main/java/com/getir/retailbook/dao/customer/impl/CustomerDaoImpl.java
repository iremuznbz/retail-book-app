package com.getir.retailbook.dao.customer.impl;

import com.getir.retailbook.dao.customer.CustomerDao;
import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.model.customer.Customer;
import com.getir.retailbook.repository.customer.CustomerRepository;
import com.getir.retailbook.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerDto customerDto) {
        Customer c = (Customer) customerMapper.mapToEntity(customerDto);
        return customerRepository.save(c).getId();
    }

    @Override
    public CustomerDto findCustomerById(String id) {
        Optional<Customer> c = customerRepository.findById(id);
        return (CustomerDto) customerMapper.mapToDto(c.get());
    }
}
