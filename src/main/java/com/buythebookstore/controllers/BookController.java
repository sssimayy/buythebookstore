package com.buythebookstore.controllers;

import com.buythebookstore.business.abstracts.BookService;
import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.Book;
import com.buythebookstore.entities.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> create(@RequestBody Book book) {
        Result result = this.bookService.create(book);
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
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        var isRemoved = bookService.delete(id);

        if (!isRemoved ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
