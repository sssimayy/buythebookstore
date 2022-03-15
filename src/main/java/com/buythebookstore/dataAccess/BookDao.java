package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {

    Book getById(int id);
}
