package com.getir.retailbook.customer.repo;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.customer.CustomerEntity;
import com.getir.retailbook.customer.CustomerMapper;
import com.getir.retailbook.customer.dto.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDaoImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public String createCustomer(CustomerDto customerDto) {
        CustomerEntity c = (CustomerEntity) customerMapper.mapToEntity(customerDto);
        return customerRepository.save(c).getId();
    }

    @Override
    public CustomerDto findCustomerById(String id) {
        Optional<CustomerEntity> c = customerRepository.findById(id);
        if (c.isEmpty())
            throw new BusinessException("C001", "Customer does not exist.");

        return (CustomerDto) customerMapper.mapToDto(c.get());
    }

    @Override
    public Optional<CustomerEntity> findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
