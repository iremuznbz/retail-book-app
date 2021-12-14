package com.getir.retailbook.customer;

import com.getir.retailbook.customer.dto.CustomerDto;

public class CustomerTestFactory {

    public static CustomerEntity createCustomerEntity(String id, String email) {
        CustomerEntity c = new CustomerEntity();
        c.setId(id);
        c.setEmail(email);
        return c;
    }

    public static CustomerDto createCustomerDto() {
        CustomerDto dto = new CustomerDto();
        dto.setName("Sezen");
        dto.setSurname("Aksu");
        dto.setEmail("sezenaksu@gmail.com");
        return dto;

    }
}

