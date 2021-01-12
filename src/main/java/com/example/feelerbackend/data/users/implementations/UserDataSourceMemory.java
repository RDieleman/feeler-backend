package com.example.feelerbackend.data.users.implementations;

import com.example.feelerbackend.data.users.UserDataSource;
import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.user.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Profile({"test", "prod", "dev"})
public class UserDataSourceMemory extends UserDataSource {
    List<UserDAO> users = new ArrayList<>();

    public UserDataSourceMemory(){
        storeNewUser("1", "ruben");
    }

    @Override
    public UserDAO storeNewUser(String id, String name) {

        UserDAO user = new UserDAO(
                id,
                name,
                new BookshelfDAO()
        );

        users.add(user);

        return user;
    }

    @Override
    public UserDAO getUserById(String id) {
        return users.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public UserDAO addBook(AddBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if(user == null) return null;

        user.getBookshelf().getContent().put(dao.getBook(), Status.UNREAD);
        return user;
    }

    @Override
    public UserDAO updateBook(UpdateBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if(user == null) return null;

        user.getBookshelf().getContent().put(dao.getBook(), dao.getStatus());
        return user;
    }

    @Override
    public UserDAO removeBook(RemoveBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if(user == null) return null;

        user.getBookshelf().getContent().remove(dao.getBook());

        return user;
    }


}
