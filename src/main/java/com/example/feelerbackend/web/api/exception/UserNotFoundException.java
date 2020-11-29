package com.example.feelerbackend.web.api.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseRestException {
    public UserNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, String.format("No user with id '%s' could be found.", id));
    }
}
