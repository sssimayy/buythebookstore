package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.BookService;
import com.buythebookstore.core.results.*;
import com.buythebookstore.dataAccess.BookDao;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookManager(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public Result add(BookDto reqDTO) {
        if (reqDTO.getBookName().length() <= 1) {
            return new ErrorResult("Book name must be longer than 1 characters");

        }
        Book book = new Book();
        book.setBookNumber(reqDTO.getBookNumber());
        book.setBookName(reqDTO.getBookName());
        book.setBookPrice(reqDTO.getBookPrice());

        bookDao.save(book);
        return new SuccessResult("Success!");
    }

    @Override
    public DataResult<List<Book>> getAll() {
        return new SuccessDataResult<List<Book>>(this.bookDao.findAll(), "Data has been listed");
    }

    @Override
    public Result update(BookDto bookDto) {
        if (!this.bookDao.existsById(bookDto.getBookId())) {
            return new ErrorResult("There is no such book!");
        } else if (bookDto.getBookName().length() < 1) {
            return new ErrorResult("Name cannot be shorter than 1 characters");
        } else if (bookDto.getBookNumber().length() < 0) {
            return new ErrorResult("The number of books cannot be less than 0");
        } else if (bookDto.getBookPrice().length() < 0) {
            return new ErrorResult("The book price cannot be less than 0");
        }
        Book book = this.bookDao.getById(bookDto.getBookId());
        book.setBookName(bookDto.getBookName());
        book.setBookPrice(bookDto.getBookPrice());
        book.setBookNumber(bookDto.getBookNumber());
        this.bookDao.save(book);
        return new SuccessResult("Information saved");
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
