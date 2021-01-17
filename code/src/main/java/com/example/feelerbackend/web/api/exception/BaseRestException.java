package com.example.feelerbackend.web.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class BaseRestException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public BaseRestException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
