package com.getir.retailbook.order.service;

import com.getir.retailbook.BusinessException;
import com.getir.retailbook.book.dto.BookDto;
import com.getir.retailbook.book.service.BookCommandService;
import com.getir.retailbook.book.service.BookQueryService;
import com.getir.retailbook.order.OrderEntity;
import com.getir.retailbook.order.OrderMapper;
import com.getir.retailbook.order.dto.Item;
import com.getir.retailbook.order.dto.OrderDto;
import com.getir.retailbook.order.repo.OrderDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderDao orderDao;
    private final BookQueryService bookQueryService;
    private final BookCommandService bookCommandService;
    private final OrderMapper orderMapper;

    public OrderCommandServiceImpl(OrderDao orderDao, BookQueryService bookQueryService, BookCommandService bookCommandService, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.bookQueryService = bookQueryService;
        this.bookCommandService = bookCommandService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public String createOrder(OrderDto orderDto) {
        List<BookDto> books = bookQueryService.findAllBooks(orderDto.getItems());

        if(books.size() != orderDto.getItems().size())
            throw new BusinessException("O002", "Cannot create order for all books in the list");

        for(Item i : orderDto.getItems()){
            BookDto bookDto = books.stream().filter(b -> b.getId().equals(i.getBookId())).findFirst().get();
            if (bookDto.getQuantity() - i.getQuantity() < 0)
                throw new BusinessException("O003", "Does not have enough stock for book " + bookDto.getName());
            bookDto.setQuantity(bookDto.getQuantity() - i.getQuantity());
        }

        bookCommandService.updateBooks(books);
        OrderEntity order = (OrderEntity) orderMapper.mapToEntity(orderDto);
        return orderDao.save(order);
    }
}
