package com.example.feelerbackend.data.users.implementations;

import com.example.feelerbackend.data.users.UserDataSource;
import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.bookshelf.item.BookshelfItem;
import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import com.example.feelerbackend.domain.model.user.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile({"test", "prod", "dev"})
public class UserDataSourceMemory extends UserDataSource {
    List<UserDAO> users = new ArrayList<>();

    public UserDataSourceMemory() {
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
    public BookshelfDAO addBook(AddBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if (user == null) return null;

        boolean exists = user.getBookshelf().getContent().stream().anyMatch(c -> c.getISBN13().equals(dao.getISBN13()));
        if (exists) return null; //todo: add exceptions

        user.getBookshelf().getContent().add(
                new BookshelfItem(
                        dao.getISBN13(),
                        Status.UNREAD
                )
        );

        return user.getBookshelf();
    }

    @Override
    public BookshelfDAO updateBook(UpdateBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if (user == null) return null;

        user.getBookshelf().getContent().stream()
                .filter(c -> c.getISBN13().equals(dao.getISBN13()))
                .findFirst().get()
                .setStatus(dao.getStatus());

        return user.getBookshelf();
    }

    @Override
    public BookshelfDAO removeBook(RemoveBookDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if (user == null) return null;

        BookshelfItem item = user.getBookshelf().getContent().stream()
                .filter(c -> c.getISBN13().equals(dao.getISBN13()))
                .findAny().get();

        user.getBookshelf().getContent().remove(item);

        return user.getBookshelf();
    }

    @Override
    public BookshelfDAO getBookshelf(GetBookshelfDAO dao) {
        UserDAO user = getUserById(dao.getUserId());
        if (user == null) return null;

        return user.getBookshelf();
    }


}
