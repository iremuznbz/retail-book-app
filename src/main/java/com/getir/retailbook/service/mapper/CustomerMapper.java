package com.getir.retailbook.service.mapper;

import com.getir.retailbook.dto.CustomerDto;
import com.getir.retailbook.model.Customer;

public class CustomerMapper implements EntityMapper {

    @Override
    public Object map(Object dto) {
        CustomerDto customerDto = (CustomerDto) dto;
        Customer c = new Customer(customerDto.getName(),customerDto.getSurname());
        return c;
    }
}
