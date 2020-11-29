package com.example.feelerbackend.web.api.exception;

import org.springframework.http.HttpStatus;

public class InvalidISBNException extends BaseRestException {
    public InvalidISBNException(String ISBN) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, String.format("The ISBN '%s' is invalid.", ISBN));
    }
}
