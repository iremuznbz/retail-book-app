package com.getir.retailbook.customer;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.repo.CustomerDaoImpl;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.customer.service.CustomerCommandServiceImpl;
import com.getir.retailbook.customer.service.CustomerQueryService;
import com.getir.retailbook.customer.service.CustomerQueryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.getir.retailbook.customer.CustomerTestFactory.createCustomerDto;
import static com.getir.retailbook.customer.CustomerTestFactory.createCustomerEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class CustomerServiceTest {

    private CustomerCommandService customerCommandService;
    private CustomerQueryService customerQueryService;
    private CustomerDaoImpl customerDao;

    @BeforeEach
    public void setUp() {
        customerDao = Mockito.mock(CustomerDaoImpl.class);
        customerCommandService = new CustomerCommandServiceImpl(customerDao);
        customerQueryService = new CustomerQueryServiceImpl(customerDao);
    }

    @Test
    public void createCustomer_IfEmailExist_ThrowsException() {
        Optional<CustomerEntity> t = Optional.of(createCustomerEntity("", "sezenaksu@gmail.com"));
        Mockito.when(customerDao.findCustomerByEmail("sezenaksu@gmail.com")).thenReturn(t);

        BusinessException exception = assertThrows(BusinessException.class, () -> customerCommandService.createCustomer(createCustomerDto()));

        String expectedMessage = "Email has been used before.";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(customerDao).findCustomerByEmail("sezenaksu@gmail.com");
    }

    @Test
    public void createCustomer_IfCustomerDoesNotExist_ThenCreateCustomer() {

        Optional<CustomerEntity> t = Optional.empty();
        Mockito.when(customerDao.findCustomerByEmail("sezenaksu@gmail.com")).thenReturn(t);

        final CustomerDto customerDto = createCustomerDto();
        String c = customerCommandService.createCustomer(customerDto);

        verify(customerDao).findCustomerByEmail("sezenaksu@gmail.com");
        verify(customerDao).createCustomer(customerDto);

    }

    @Test
    public void findCustomerById_IfCustomerExist_ReturnsCustomerDto() {
        final CustomerDto customerDto = createCustomerDto();
        Mockito.when(customerDao.findCustomerById("61b28088d5d37d67dbd6cbba")).thenReturn(customerDto);

        CustomerDto c = customerQueryService.findCustomerById("61b28088d5d37d67dbd6cbba");

        verify(customerDao).findCustomerById("61b28088d5d37d67dbd6cbba");

    }

}
