package com.example.feelerbackend.web.api.exception.implementations;

import com.example.feelerbackend.web.api.exception.BaseRestException;
import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends BaseRestException {
    public InvalidArgumentException(String value) {
        super(HttpStatus.UNPROCESSABLE_ENTITY,
                String.format("Argument with value '%s' is invalid.", value));
    }
}
