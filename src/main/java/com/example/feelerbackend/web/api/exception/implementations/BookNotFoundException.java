package com.example.feelerbackend.web.api.exception.implementations;

import com.example.feelerbackend.web.api.exception.BaseRestException;
import org.springframework.http.HttpStatus;

public class BookNotFoundException extends BaseRestException {
    public BookNotFoundException(String ISBN) {
        super(HttpStatus.NOT_FOUND, String.format("No book with ISBN '%s' could be found.", ISBN));
    }
}
