package com.getir.retailbook.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.retailbook.customer.dto.CustomerCreateRequest;
import com.getir.retailbook.customer.service.CustomerCommandService;
import com.getir.retailbook.order.service.OrderQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", password = "admin")   //DefaultUser with username "user", password "password", and a single GrantedAuthority named "ROLE_USER"
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerCommandService customerCommandService;

    @Mock
    private OrderQueryService orderQueryService;

    @Mock
    private CustomerMapper customerMapper;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void createCustomer_IfNameIsNull_Returns400Error() throws Exception {
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setSurname("surname");
        request.setEmail("email@email.com");

        mockMvc.perform(post("/customer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_IfSurnameIsNull_Returns400Error() throws Exception {
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setName("name");
        request.setEmail("email@email.com");

        mockMvc.perform(post("/customer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_IfEmailIsNull_Returns400Error() throws Exception {
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setName("name");
        request.setSurname("surname");

        mockMvc.perform(post("/customer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createCustomer_IfAllFieldsExist_Returns200Success() throws Exception {
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setName("name");
        request.setSurname("surname");
        request.setEmail("email@email.com");

        mockMvc.perform(post("/customer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    public void getCustomerOrders_IfAllFieldsExist_Returns200Success() throws Exception {
        mockMvc.perform(get("/customer/orders/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
