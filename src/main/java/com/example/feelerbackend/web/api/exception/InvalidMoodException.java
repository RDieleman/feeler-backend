package com.example.feelerbackend.web.api.exception;

import org.springframework.http.HttpStatus;

public class InvalidMoodException extends BaseRestException{
    public InvalidMoodException(String value) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, String.format("The value '%s' is an invalid mood.", value));
    }
}
