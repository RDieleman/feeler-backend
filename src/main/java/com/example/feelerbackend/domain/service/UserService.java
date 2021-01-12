package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.dao.UserDAO;
import com.example.feelerbackend.data.users.repositories.IUserRepository;
import com.example.feelerbackend.domain.model.user.User;
import com.example.feelerbackend.domain.model.user.UserDTO;
import com.example.feelerbackend.domain.util.mapper.IUserMapper;
import com.example.feelerbackend.web.api.exception.implementations.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userDataSource;
    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserRepository userDataSource, IUserMapper userMapper) {
        this.userDataSource = userDataSource;
        this.userMapper = userMapper;
    }

    public UserDTO getUserById(long id){

        UserDAO dao = userDataSource.findById(id).orElse(null);
        if(dao == null) throw new UserNotFoundException(id);

        User model = userMapper.toModel(dao);
        return userMapper.toDTO(model);
    }
}
