package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BookAddDto {

    @NotBlank
    private String bookName;

    @NotBlank
    private String bookNumber;

    @NotBlank
    private String bookPrice;

    private int kindId;
}
