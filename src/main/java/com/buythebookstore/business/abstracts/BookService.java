package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookDto;

import java.util.List;

public interface BookService {

    public Result add(BookDto book);

    public DataResult<List<Book>> getAll();

    public Result update(BookDto staffUpdateDto);

    boolean delete(Long id);
}
