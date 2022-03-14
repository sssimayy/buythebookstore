package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.OrderService;
import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.ErrorDataResult;
import com.buythebookstore.core.results.SuccessDataResult;
import com.buythebookstore.dataAccess.OrderDao;
import com.buythebookstore.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements OrderService {

    OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public DataResult<Order> add(Order order) {
        if (!this.orderDao.existsById(order.getId())) {
            return new ErrorDataResult<>(order, "Order does not exist");
        } else {
            this.orderDao.save(order);
            return new SuccessDataResult<>("Order has been created.");
        }
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
