package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.dao.UserDAO;
import com.example.feelerbackend.data.users.source.IUserDataSource;
import com.example.feelerbackend.domain.model.User;
import com.example.feelerbackend.domain.util.mapper.UserMapper;
import com.example.feelerbackend.web.api.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserDataSource userDataSource;
    private final UserMapper userMapper;

    public UserService(IUserDataSource userDataSource, UserMapper userMapper) {
        this.userDataSource = userDataSource;
        this.userMapper = userMapper;
    }

    public User getUserById(String id){
        UserDAO dao = userDataSource.getUserInfoById(id);
        if(dao == null) throw new UserNotFoundException(id);

        return userMapper.mapUser(dao);
    }
}
