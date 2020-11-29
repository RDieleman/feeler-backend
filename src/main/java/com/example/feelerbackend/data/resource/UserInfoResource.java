package com.example.feelerbackend.data.resource;

import com.example.feelerbackend.data.dao.UserDAO;

public interface UserInfoResource {
    UserDAO getUserInfoById(String Id);
}
