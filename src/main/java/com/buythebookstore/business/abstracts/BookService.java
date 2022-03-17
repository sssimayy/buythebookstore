package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookAddDto;
import com.buythebookstore.entities.dtos.BookDto;
import com.buythebookstore.entities.dtos.BookRecommendationDto;

import java.util.List;

public interface BookService {

    Result add(BookAddDto book);

    DataResult<List<Book>> getAll();

    Result update(BookDto staffUpdateDto);

    boolean delete(int id);

    DataResult<List<BookRecommendationDto>> getRecommendation(int id);
}
