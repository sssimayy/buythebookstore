package com.buythebookstore.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRecommendationDto implements Comparable<BookRecommendationDto> {

    private int bookId;

    @NotBlank
    private String bookName;

    @NotBlank
    private String bookNumber;

    @NotBlank
    private String bookPrice;

    private int totalSell;

    public BookRecommendationDto(int bookId, String bookName, String bookNumber, String bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.bookPrice = bookPrice;
    }

    @Override
    public int compareTo(BookRecommendationDto o) {
        return (o.totalSell - totalSell);
    }
}
