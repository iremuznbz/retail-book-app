package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerCreateRequest;
import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.util.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements EntityMapper {

    @Override
    public Object mapToEntity(Object dto) {
        CustomerDto customerDto = (CustomerDto) dto;
        CustomerEntity c = new CustomerEntity();
        c.setId(((CustomerDto) dto).getId());
        c.setName(customerDto.getName());
        c.setSurname(customerDto.getSurname());
        c.setEmail(customerDto.getEmail());
        return c;
    }

    @Override
    public Object mapToDto(Object entity) {
        CustomerEntity c = (CustomerEntity) entity;
        CustomerDto dto = new CustomerDto(c.getId(), c.getName() , c.getSurname(), c.getEmail());
        return dto;
    }


    public CustomerDto fromCreateRequestToDto(CustomerCreateRequest req) {
        CustomerDto dto = new CustomerDto(req.getName(), req.getSurname(), req.getEmail());
        return dto;
    }
}
