package com.example.feelerbackend.web.api.exception.implementations;

import com.example.feelerbackend.web.api.exception.BaseRestException;
import org.springframework.http.HttpStatus;

public class BookshelfNotFoundException extends BaseRestException {
    public BookshelfNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, String.format("No bookshelf with id '%s' could be found.", id));
    }
}
