package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.user.User;
import com.example.feelerbackend.domain.model.user.UserDTO;
import com.example.feelerbackend.domain.service.UserService;
import com.example.feelerbackend.web.api.exception.BaseRestException;
import com.example.feelerbackend.web.api.exception.ExceptionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping("/user")
@Api(tags = "Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get the user's info by it's id
     * @param id The user's id
     * @return  Object containing the user's info
     */
    @ApiOperation(
            value = "Get info about a specific user"
    )
    @ApiResponse(
            code=200, message="The info about the requested user has been returned."
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id){
        UserDTO resource = userService.getUserById(id);
        return ResponseEntity.ok(resource);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(BaseRestException exception){
        ExceptionResponse response = new ExceptionResponse(exception.getStatus(), exception.getMessage());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
