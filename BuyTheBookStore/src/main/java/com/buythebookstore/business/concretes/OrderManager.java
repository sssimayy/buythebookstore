package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.OrderService;
import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.SuccessDataResult;
import com.buythebookstore.dataAccess.BookDao;
import com.buythebookstore.dataAccess.OrderDao;
import com.buythebookstore.dataAccess.OrderDetailDao;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.Order;
import com.buythebookstore.entities.OrderDetail;
import com.buythebookstore.entities.dtos.OrderDetailDto;
import com.buythebookstore.entities.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderManager implements OrderService {

    private final OrderDao orderDao;
    private final OrderDetailDao orderDetailDao;
    private final BookDao bookDao;

    @Autowired
    public OrderManager(OrderDao orderDao, OrderDetailDao orderDetailDao, BookDao bookDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
        this.bookDao = bookDao;
    }

    @Override
    public DataResult<Order> add(OrderDto orderDto) {
        List<OrderDetailDto> orderDetails = orderDto.getOrderDetails();
//        List<OrderDetail> detailList = new ArrayList<>();
        OrderDetail orderDetail;

        Order order = new Order();
//        order.setOrderDetails(detailList);
        order.setOrderNumber(UUID.randomUUID().toString());
        this.orderDao.save(order);

        for (OrderDetailDto orderDetailItem : orderDetails) {
            Book book = bookDao.getById(orderDetailItem.getBookId());
            orderDetail = new OrderDetail();
            orderDetail.setNumber(orderDetailItem.getNumber());
            orderDetail.setBook(book);
//            detailList.add(orderDetail);
            orderDetail.setOrder(order);
            orderDetailDao.save(orderDetail);
        }


        return new SuccessDataResult<>("Order has been created.");
    }

    @Override
    public DataResult<List<Order>> getAll() {
        return new SuccessDataResult<List<Order>>(this.orderDao.findAll());
    }

    /*@Override
    public Result update(OrderDto orderUpdateDto) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }*/
}
