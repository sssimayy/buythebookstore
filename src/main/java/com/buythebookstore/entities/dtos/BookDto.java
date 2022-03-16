package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BookDto {

    public BookDto(int bookId, String bookName, String bookNumber, String bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.bookPrice = bookPrice;
    }

    public BookDto() {
    }

    private int bookId;
    @NotBlank
    private String bookName;

    @NotBlank
    private String bookNumber;

    @NotBlank
    private String bookPrice;
}
