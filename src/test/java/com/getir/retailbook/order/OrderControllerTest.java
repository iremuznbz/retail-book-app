package com.getir.retailbook.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getir.retailbook.customer.dto.CustomerCreateRequest;
import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderCreateRequest;
import com.getir.retailbook.order.service.OrderCommandService;
import com.getir.retailbook.order.service.OrderQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(username = "admin", password = "admin")
@AutoConfigureMockMvc
class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderCommandService orderCommandService;

    @Mock
    private OrderQueryService orderQueryService;

    @Mock
    private OrderMapper orderMapper;

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void createOrder_IfCustomerIdIsNull_Returns400Error() throws Exception {
        OrderCreateRequest request = new OrderCreateRequest();
        request.setBooks(Arrays.asList(new Item("id", 10, BigDecimal.TEN)));

        mockMvc.perform(post("/order")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void createOrder_IfBookListIsEmpty_Returns400Error() throws Exception {
        OrderCreateRequest request = new OrderCreateRequest();
        request.setCustomerId("id");
        request.setBooks(new ArrayList<Item>());

        mockMvc.perform(post("/order")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findOrderById_IfAllFieldsExist_Returns200Success() throws Exception {
        mockMvc.perform(get("/order/{orderId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void listOrdersByInterval_IfAllFieldsExist_Returns200Success() throws Exception {
            mockMvc.perform(get("/order/search")
                    .param( "startDate","2021-11-05")
                    .param("endDate","2021-12-05")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

}
