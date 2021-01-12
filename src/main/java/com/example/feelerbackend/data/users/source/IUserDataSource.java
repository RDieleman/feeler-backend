package com.example.feelerbackend.data.users.source;

import com.example.feelerbackend.data.users.dao.UserDAO;

public interface IUserDataSource {
    UserDAO getUserInfoById(String Id);
}
