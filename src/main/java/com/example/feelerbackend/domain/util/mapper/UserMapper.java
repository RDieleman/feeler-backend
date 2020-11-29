package com.example.feelerbackend.domain.util.mapper;

import com.example.feelerbackend.data.dao.UserDAO;
import com.example.feelerbackend.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User mapUser(UserDAO dao){
        User user = new User();
        user.setId(dao.getId());
        user.setName(dao.getName());
        user.setWant_to_read_list(dao.getWant_to_read_list());
        return user;
    }
}
