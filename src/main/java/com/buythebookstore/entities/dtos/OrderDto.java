package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderDto {

    @NotBlank
    private String orderNumber;
}
