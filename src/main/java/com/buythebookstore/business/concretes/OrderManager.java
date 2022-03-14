package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.OrderService;
import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.Order;
import com.buythebookstore.entities.dtos.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements OrderService {
    @Override
    public Result create(Order staff) {
        return null;
    }

    @Override
    public DataResult<List<Order>> getAll() {
        return null;
    }

    @Override
    public Result update(OrderDto orderUpdateDto) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
