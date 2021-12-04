package com.getir.retailbook.customer.service.mapper;

import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements EntityMapper {

    @Override
    public Object map(Object dto) {
        CustomerDto customerDto = (CustomerDto) dto;
        Customer c = new Customer(customerDto.getName(),customerDto.getSurname());
        return c;
    }
}
