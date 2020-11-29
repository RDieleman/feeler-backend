package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.dao.UserDAO;
import com.example.feelerbackend.data.resource.UserInfoResourceImpl;
import com.example.feelerbackend.domain.model.User;
import com.example.feelerbackend.domain.util.mapper.UserMapper;
import com.example.feelerbackend.web.api.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserInfoResourceImpl userInfoResource;
    private final UserMapper userMapper;

    public UserService(UserInfoResourceImpl userInfoResource, UserMapper userMapper) {
        this.userInfoResource = userInfoResource;
        this.userMapper = userMapper;
    }

    public User getUserById(String id){
        UserDAO dao = userInfoResource.getUserInfoById(id);
        if(dao == null) throw new UserNotFoundException(id);

        return userMapper.mapUser(dao);
    }
}
