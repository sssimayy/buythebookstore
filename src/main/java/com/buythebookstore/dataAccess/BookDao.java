package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    Book getById(int id);

    @Query("Select new  com.buythebookstore.entities.dtos.BookDto(b.id,b.bookName,b.bookNumber,b.bookPrice) From Book b Inner Join b.orderDetail o " +
            "where  b.kind=:kind order by o.number desc")
    List<BookDto> findAllByKindOrderByNumberDesc(String kind);
}
