package com.example.feelerbackend.data.users;

import com.example.feelerbackend.data.DataSource;

public abstract class UserDataSource extends DataSource implements IUserDataSource{
    public UserDataSource() {
        super("UserDataSource");
    }
}