package com.buythebookstore.controllers;

import com.buythebookstore.business.abstracts.OrderService;
import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.Order;
import com.buythebookstore.entities.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getall")
    public DataResult<List<Order>> getAll() {
        return this.orderService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody OrderDto order) {
        Result result = this.orderService.add(order);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    /*@PutMapping("/update")
    public ResponseEntity<?> update(OrderDto orderDto) {
        Result result = this.orderService.update(orderDto);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        var isRemoved = orderService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }*/
}
