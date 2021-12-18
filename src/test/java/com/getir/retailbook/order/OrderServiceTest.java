package com.getir.retailbook.order;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.book.service.BookCommandService;
import com.getir.retailbook.book.service.BookQueryService;
import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.repo.OrderDao;
import com.getir.retailbook.order.service.OrderCommandService;
import com.getir.retailbook.order.service.OrderCommandServiceImpl;
import com.getir.retailbook.order.service.OrderQueryService;
import com.getir.retailbook.order.service.OrderQueryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.getir.retailbook.book.BookTestFactory.createBookDto;
import static com.getir.retailbook.book.BookTestFactory.createBookDtos;
import static com.getir.retailbook.order.OrderTestFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {

    private OrderQueryService orderQueryService;
    private OrderCommandService orderCommandService;
    private OrderDao orderDao;
    private BookQueryService bookQueryService;
    private BookCommandService bookCommandService;
    private OrderMapper orderMapper;

    @BeforeEach
    public void setUp() {
        orderDao = mock(OrderDao.class);
        bookQueryService = mock(BookQueryService.class);
        bookCommandService = mock(BookCommandService.class);
        orderMapper = mock(OrderMapper.class);
        orderQueryService = new OrderQueryServiceImpl(orderDao);
        orderCommandService = new OrderCommandServiceImpl(orderDao, bookQueryService, bookCommandService, orderMapper);

        Mockito.when(orderMapper.mapToEntity(Mockito.any())).thenReturn(createOrderEntity());

        Item i = createItem("61bce5a81e74a322432c85ed", 5, 12.90);
        Item i2 = createItem("61bce6101e74a322432c85ef", 15, 24.90);
        Mockito.when(orderMapper.mapToDto(Mockito.any())).thenReturn(createOrderDto(Arrays.asList(i,i2)));
    }

    @Test
    public void createOrder_IfBookHasEnoughQuantitiesAndStock_ThenCreatesOrder() {
        Item i = createItem("61bce5a81e74a322432c85ed", 5, 12.90);
        Item i2 = createItem("61bce6101e74a322432c85ef", 15, 24.90);
        final OrderDto orderDto = createOrderDto(Arrays.asList(i, i2));

        BookDto b = createBookDto("61bce6101e74a322432c85ef", "Veronika Olmek Istiyor", 200, 24.90);
        BookDto b2 = createBookDto("61bce5a81e74a322432c85ed", "Mindfullness", 520, 12.90);
        Mockito.when(bookQueryService.findAllBooks(orderDto.getItems())).thenReturn(createBookDtos(Arrays.asList(b, b2)));

        orderCommandService.createOrder(orderDto);
        verify(bookCommandService).updateBooks(Mockito.anyList());
        verify(orderDao).save(Mockito.any(OrderEntity.class));
    }

    @Test
    public void createOrder_IfBookHasNotEnoughStock_ThenThrowsException() {
        Item i = createItem("61bce5a81e74a322432c85ed", 5, 12.90);
        Item i2 = createItem("61bce6101e74a322432c85ef", 15, 24.90);
        final OrderDto orderDto = createOrderDto(Arrays.asList(i, i2));

        BookDto b = createBookDto("61bce6101e74a322432c85ef", "Veronika Olmek Istiyor", 2, 24.90);
        BookDto b2 = createBookDto("61bce5a81e74a322432c85ed", "Mindfullness", 5, 12.90);
        Mockito.when(bookQueryService.findAllBooks(orderDto.getItems())).thenReturn(createBookDtos(Arrays.asList(b, b2)));

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            orderCommandService.createOrder(orderDto);
        });

        String expectedMessage = "Does not have enough stock for book ";
        String actualMessage = exception.getMsg();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(bookQueryService).findAllBooks(Mockito.anyList());
    }

    @Test
    public void findOrderById_IfOrderExist_ThenReturnsOrderDto() {
        Mockito.when(orderDao.findOrderById("61bce6391e74a322432c85f0")).thenReturn(createOrderDto(Arrays.asList(createItem("61bce6101e74a322432c85ef", 15, 24.90))));
        OrderDto id = orderQueryService.findOrderById("61bce6391e74a322432c85f0");
        verify(orderDao).findOrderById("61bce6391e74a322432c85f0");
        assertNotNull(id);
    }

    @Test
    public void listOrdersByInterval_IfDatesGiven_ThenReturnList() {
        Item i = createItem("61bce5a81e74a322432c85ed", 5, 12.90);
        Item i2 = createItem("61bce6101e74a322432c85ef", 15, 24.90);

        Mockito.when(orderDao.listOrdersByInterval(LocalDateTime.of(2021,10,5,0,0),LocalDateTime.of(2021,12,5,0,0))).thenReturn(Arrays.asList(createOrderDto(Arrays.asList(i,i2))));
        orderQueryService.listOrdersByInterval(LocalDate.of(2021,10,5),LocalDate.of(2021,12,5));
        verify(orderDao).listOrdersByInterval(LocalDateTime.of(2021,10,5,0,0),LocalDateTime.of(2021,12,5,0,0));
    }

    @Test
    public void findOrderListByCustomerID_IfCustomerIdGiven_ThenReturnsList() {
        Mockito.when(orderDao.findOrderListByCustomerID("61bce5c81e74a322432c85ee")).thenReturn(Arrays.asList(createOrderDto(Arrays.asList(createItem("61bce6101e74a322432c85ef", 15, 24.90)))));
        List<OrderDto> orders = orderQueryService.findOrderListByCustomerID("61bce5c81e74a322432c85ee");

        assertTrue(orders.size() == 1);
        verify(orderDao).findOrderListByCustomerID("61bce5c81e74a322432c85ee");

    }
}
