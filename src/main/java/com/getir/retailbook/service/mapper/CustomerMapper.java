package com.getir.retailbook.service.mapper;

import com.getir.retailbook.dto.customer.CustomerDto;
import com.getir.retailbook.model.customer.Customer;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements EntityMapper {

    @Override
    public Object mapToEntity(Object dto) {
        CustomerDto customerDto = (CustomerDto) dto;
        Customer c = new Customer();
        c.setName(customerDto.getName());
        c.setSurname(customerDto.getName());
        return c;
    }

    @Override
    public Object mapToDto(Object entity) {
        Customer c = (Customer) entity;
        CustomerDto dto = new CustomerDto(c.getId(), c.getName() , c.getSurname());
        return dto;
    }


}
