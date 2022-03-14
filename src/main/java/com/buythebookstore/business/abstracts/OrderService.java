package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.Order;
import com.buythebookstore.entities.dtos.OrderDto;

import java.util.List;

public interface OrderService {
    public Result create(Order staff);

    public DataResult<List<Order>> getAll();

    public Result update(OrderDto orderUpdateDto);

    boolean delete(Long id);
}
