package com.example.feelerbackend.web.api.exception.implementations;

import com.example.feelerbackend.web.api.exception.BaseRestException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseRestException {
    public UserNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, String.format("No user with id '%s' could be found.", id));
    }
}
