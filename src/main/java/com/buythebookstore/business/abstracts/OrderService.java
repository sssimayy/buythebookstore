package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.entities.Order;
import com.buythebookstore.entities.dtos.OrderDto;

import java.util.List;

public interface OrderService {
    DataResult<Order> add(OrderDto order);

    public DataResult<List<Order>> getAll();

    //public Result update(OrderDto orderUpdateDto);

    //boolean delete(Long id);
}
