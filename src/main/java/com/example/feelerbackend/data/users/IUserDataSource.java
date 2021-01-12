package com.example.feelerbackend.data.users;

import com.example.feelerbackend.domain.model.bookshelf.AddBookDAO;
import com.example.feelerbackend.domain.model.bookshelf.RemoveBookDAO;
import com.example.feelerbackend.domain.model.bookshelf.UpdateBookDAO;
import com.example.feelerbackend.domain.model.user.UserDAO;

public interface IUserDataSource {
    UserDAO storeNewUser(String id, String name);
    UserDAO getUserById(String Id);
    UserDAO addBook(AddBookDAO dao);
    UserDAO updateBook(UpdateBookDAO dao);
    UserDAO removeBook(RemoveBookDAO dao);
}
