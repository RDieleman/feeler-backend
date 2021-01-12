package com.example.feelerbackend.data.users;

import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.user.UserDAO;

public interface IUserDataSource {
    UserDAO storeNewUser(String id, String name);
    UserDAO getUserById(String Id);
    BookshelfDAO addBook(AddBookDAO dao);
    BookshelfDAO updateBook(UpdateBookDAO dao);
    BookshelfDAO removeBook(RemoveBookDAO dao);
    BookshelfDAO getBookshelf(GetBookshelfDAO dao);
}
