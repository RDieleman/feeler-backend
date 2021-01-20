package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.dao.UserDAO;
import com.example.feelerbackend.data.users.repositories.IUserRepository;
import com.example.feelerbackend.domain.model.user.UserDTO;
import com.example.feelerbackend.web.api.exception.implementations.UserNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private IUserRepository userRepository;

    private UserDAO mockUser;
    private String username = "username";

    @BeforeEach
    void beforeEach() {
        UserDAO user = new UserDAO();
        user.setName(username);

        mockUser = userRepository.save(user);
    }

    @Test
    void getUserByIdInvalidIdThrowsUserNotFoundException() {
        //setup
        Throwable e = null;

        //execute
        try{
            userService.getUserById(mockUser.getId() + 10);
        }catch (Throwable thrown){
            e = thrown;
        }

        //assert
        assertTrue(e instanceof UserNotFoundException);
    }

    @Test
    void getUserByValidIdReturnsUser(){
        //execute
        UserDTO user = userService.getUserById(mockUser.getId());

        //assert
        assertNotNull(user);
        assertEquals(user.getId(), mockUser.getId());
    }
}