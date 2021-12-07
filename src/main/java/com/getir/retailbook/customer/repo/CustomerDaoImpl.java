package com.getir.retailbook.customer.repo;

import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.CustomerMapper;
import com.getir.retailbook.customer.dto.CustomerDto;
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
        CustomerEntity c = (CustomerEntity) customerMapper.mapToEntity(customerDto);
        return customerRepository.save(c).getId();
    }

    @Override
    public CustomerDto findCustomerById(String id) {
        Optional<CustomerEntity> c = customerRepository.findById(id);
        return (CustomerDto) customerMapper.mapToDto(c.get());
    }
}
