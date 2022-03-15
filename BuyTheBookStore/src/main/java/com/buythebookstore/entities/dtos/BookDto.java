package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BookDto {

    private int bookId;
    @NotBlank
    private String bookName;

    @NotBlank
    private String bookNumber;

    @NotBlank
    private String bookPrice;
}
