package com.getir.retailbook.customer;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.customer.dto.CustomerDto;
import com.getir.retailbook.customer.repo.CustomerDao;
import com.getir.retailbook.customer.repo.CustomerDaoImpl;
import com.getir.retailbook.customer.repo.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.getir.retailbook.customer.CustomerTestFactory.createCustomerDto;
import static com.getir.retailbook.customer.CustomerTestFactory.createCustomerEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class CustomerDaoTest {

    private CustomerRepository customerRepository;
    private CustomerDao customerDao;
    private CustomerMapper customerMapper;

    @BeforeEach
    public void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerMapper = new CustomerMapper();
        customerDao = new CustomerDaoImpl(customerRepository, customerMapper);
    }

    @Test
    public void createCustomer_WhenDtoPassed_SavesEntity() {
        Mockito.when(customerRepository.save(Mockito.any(CustomerEntity.class))).thenReturn(createCustomerEntity("61b28088d5d37d67dbd6cbba",""));
        final CustomerDto customerDto = createCustomerDto();
        String id = customerDao.createCustomer(customerDto);

        verify(customerRepository).save(Mockito.any(CustomerEntity.class));
    }

    @Test
    public void findCustomerById_IfCustomerDoesNotExist_ThrowsException() {
        Optional<CustomerEntity> t = Optional.empty();
        Mockito.when(customerRepository.findById("61b28088d5d37d67dbd6cbba")).thenReturn(t);


        BusinessException exception = assertThrows(BusinessException.class, () -> {
            customerDao.findCustomerById("61b28088d5d37d67dbd6cbba");
        });

        String expectedMessage = "Customer does not exist.";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(customerRepository).findById("61b28088d5d37d67dbd6cbba");
    }

    @Test
    public void findCustomerById_IfCustomerDoesExist_ThenReturnsCustomer() {
        CustomerEntity customer = createCustomerEntity("61b28088d5d37d67dbd6cbba","");
        Optional<CustomerEntity> t = Optional.of(customer);
        Mockito.when(customerRepository.findById("61b28088d5d37d67dbd6cbba")).thenReturn(t);

        CustomerDto c = customerDao.findCustomerById("61b28088d5d37d67dbd6cbba");

        verify(customerRepository).findById("61b28088d5d37d67dbd6cbba");
        assertEquals("61b28088d5d37d67dbd6cbba", c.getId());
    }




}
