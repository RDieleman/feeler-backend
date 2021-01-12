package com.example.feelerbackend.data.users;

import com.example.feelerbackend.domain.model.user.UserDAO;

public interface IUserDataSource {
    UserDAO storeNewUser(String id, String name);
    UserDAO getUserById(String Id);
}
