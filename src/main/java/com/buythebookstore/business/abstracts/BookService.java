package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookDto;

import java.util.List;

public interface BookService {

    public Result create(Book book);

    public DataResult<List<Book>> getAll();

    public Result update(BookDto staffUpdateDto);

    boolean delete(Long id);
}
