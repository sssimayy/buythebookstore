package com.buythebookstore.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private List<OrderDetailDto> orderDetails;
}
