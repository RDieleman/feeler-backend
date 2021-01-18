package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.service.BookService;
import com.example.feelerbackend.web.api.exception.BaseRestException;
import com.example.feelerbackend.web.api.exception.ExceptionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/book")
@Api(tags = "Books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    /**
     * Get detailed info about a book by it's ISBN
     * @param ISBN Unique id of the book consisting of 10 or 13 characters
     * @return An object containing the info about the book connected to the provided id
     */
    @ApiOperation(
            value = "Get detailed info about a specific book"
    )
    @ApiResponse(
            code=200, message="An object containing the info about the request book has been returned."
    )
    @GetMapping(value= "/{ISBN}")
    public ResponseEntity<BookDTO> getBookByISBN(@PathVariable String ISBN){
        BookDTO resource = bookService.getBookByISBN(ISBN);

        return ResponseEntity.ok(resource);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BaseRestException exception){
        ExceptionResponse response = new ExceptionResponse(exception.getStatus(), exception.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
