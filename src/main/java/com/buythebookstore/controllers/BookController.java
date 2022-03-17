package com.buythebookstore.controllers;

import com.buythebookstore.business.abstracts.BookService;
import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookAddDto;
import com.buythebookstore.entities.dtos.BookDto;
import com.buythebookstore.entities.dtos.BookRecommendationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin  //default olarak dışarıya izin verir
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getall")
    public DataResult<List<Book>> getAll() {
        return this.bookService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody BookAddDto book) {
        Result result = this.bookService.add(book);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(BookDto bookDto) {
        Result result = this.bookService.update(bookDto);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping(value = "/book/{id}")
    public Boolean deletePost(@PathVariable int id) {

        return this.bookService.delete(id);
    }

    @GetMapping("/recommendation/{id}")
    public DataResult<List<BookRecommendationDto>> getRecommendedBooks(@PathVariable int id) {
        return this.bookService.getRecommendation(id);
    }
}