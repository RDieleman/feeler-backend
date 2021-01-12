package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.IUserDataSource;
import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.user.UserDAO;
import com.example.feelerbackend.domain.util.mapper.IBookMapper;
import com.example.feelerbackend.domain.util.mapper.IBookshelfMapper;
import org.springframework.stereotype.Service;

@Service
public class BookshelfService {
    private final IUserDataSource userDataSource;
    private final UserService userService;
    private final IBookshelfMapper bookshelfMapper;
    private final IBookMapper bookMapper;

    public BookshelfService(IUserDataSource userDataSource, UserService userService, IBookshelfMapper bookshelfMapper, IBookMapper bookMapper) {
        this.userDataSource = userDataSource;
        this.userService = userService;
        this.bookshelfMapper = bookshelfMapper;
        this.bookMapper = bookMapper;
    }

    public BookshelfDTO addBook(AddBookDTO dto){
        Book bookModel = bookMapper.toModel(dto.getBook());
        UserDAO dao = userDataSource.addBook(
                new AddBookDAO(
                        dto.getUserId(),
                        bookMapper.toDAO(bookModel)
                )
        );

        Bookshelf model = bookshelfMapper.toModel(dao.getBookshelf());
        return bookshelfMapper.toDTO(model);
    }

    public BookshelfDTO updateBook(UpdateBookDTO dto){
        Book bookModel = bookMapper.toModel(dto.getBook());
        UserDAO dao = userDataSource.updateBook(
                new UpdateBookDAO(
                        dto.getUserId(),
                        bookMapper.toDAO(bookModel),
                        dto.getStatus()
                )
        );

        Bookshelf model = bookshelfMapper.toModel(dao.getBookshelf());
        return bookshelfMapper.toDTO(model);
    }

    public BookshelfDTO removeBook(RemoveBookDTO dto){
        Book bookModel = bookMapper.toModel(dto.getBook());
        UserDAO dao = userDataSource.removeBook(
                new RemoveBookDAO(
                        dto.getUserId(),
                        bookMapper.toDAO(bookModel)
                )
        );

        Bookshelf model = bookshelfMapper.toModel(dao.getBookshelf());
        return bookshelfMapper.toDTO(model);
    }
}
