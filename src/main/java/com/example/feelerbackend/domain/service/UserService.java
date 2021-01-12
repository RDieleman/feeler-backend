package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.user.UserDAO;
import com.example.feelerbackend.data.users.IUserDataSource;
import com.example.feelerbackend.domain.model.user.User;
import com.example.feelerbackend.domain.model.user.UserDTO;
import com.example.feelerbackend.domain.util.mapper.IUserMapper;
import com.example.feelerbackend.web.api.exception.implementations.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserDataSource userDataSource;
    private final IUserMapper userMapper;

    public UserService(IUserDataSource userDataSource, IUserMapper userMapper) {
        this.userDataSource = userDataSource;
        this.userMapper = userMapper;
    }

    public UserDTO getUserById(String id){
        UserDAO dao = userDataSource.getUserById(id);
        if(dao == null) throw new UserNotFoundException(id);
        User model = userMapper.toModel(dao);
        return userMapper.toDTO(model);
    }
}
