package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookRecommendationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    Book getById(int id);

    @Query(value = "Select new com.buythebookstore.entities.dtos.BookRecommendationDto(b.id, b.bookName, b.bookNumber, b.bookPrice) From Book b Inner Join b.kind k " +
            "where  k.kind=:kind")
    List<BookRecommendationDto> findAllByKind(String kind);
}