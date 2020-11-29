package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.service.BookService;
import com.example.feelerbackend.web.api.exception.BaseRestException;
import com.example.feelerbackend.web.api.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(value= "/book/{ISBN}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String ISBN){
        Book resource = bookService.getBookByISBN(ISBN);

        return ResponseEntity.ok(resource);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BaseRestException exception){
        ExceptionResponse response = new ExceptionResponse(exception.getStatus(), exception.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
