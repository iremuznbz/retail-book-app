package com.getir.retailbook.customer.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerCreateRequest implements Serializable {

    @NotNull
    private CustomerDto customerDto;

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}
