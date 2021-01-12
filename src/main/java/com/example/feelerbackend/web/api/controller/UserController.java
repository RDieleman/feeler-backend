package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.user.User;
import com.example.feelerbackend.domain.service.UserService;
import com.example.feelerbackend.web.api.exception.BaseRestException;
import com.example.feelerbackend.web.api.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        User resource = userService.getUserById(id);
        return ResponseEntity.ok(resource);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BaseRestException exception){
        ExceptionResponse response = new ExceptionResponse(exception.getStatus(), exception.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
