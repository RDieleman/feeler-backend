package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.dao.BookshelfDAO;
import com.example.feelerbackend.data.users.dao.BookshelfItemDAO;
import com.example.feelerbackend.data.users.repositories.IBookshelfRepository;
import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import com.example.feelerbackend.domain.util.mapper.IBookshelfMapper;
import com.example.feelerbackend.web.api.exception.implementations.BookNotFoundException;
import com.example.feelerbackend.web.api.exception.implementations.BookshelfNotFoundException;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookshelfService {
    private final IBookshelfRepository bookshelfDataSource;
    private final IBookshelfMapper bookshelfMapper;

    @Autowired
    public BookshelfService(IBookshelfRepository bookshelfDataSource, IBookshelfMapper bookshelfMapper) {
        this.bookshelfDataSource = bookshelfDataSource;
        this.bookshelfMapper = bookshelfMapper;
    }

    public BookshelfDTO getBookshelf(GetBookshelfDTO dto) {

        if(dto == null) throw new InvalidArgumentException("dto");

        BookshelfDAO dao = bookshelfDataSource.findById(dto.getBookshelfId())
                .orElse(null);

        if(dao == null) throw new BookshelfNotFoundException(dto.getBookshelfId());

        Bookshelf model = bookshelfMapper.toModel(dao);
        return bookshelfMapper.toDTO(model);
    }

    public BookshelfDTO addBook(AddBookDTO dto) {
        if(dto == null) throw new InvalidArgumentException("dto");

        BookshelfDAO dao = bookshelfDataSource.findById(dto.getBookshelfId())
                .orElse(null);

        if(dao == null) throw new BookshelfNotFoundException(dto.getBookshelfId());

        BookshelfItemDAO item = new BookshelfItemDAO();
        item.setISBN13(dto.getISBN13());
        item.setStatus(Status.UNREAD);

        dao.getContent().add(item);

        dao = bookshelfDataSource.save(dao);

        Bookshelf model = bookshelfMapper.toModel(dao);

        return bookshelfMapper.toDTO(model);
    }

    public BookshelfDTO updateBook(UpdateBookDTO dto) {
        if(dto == null) throw new InvalidArgumentException("dto");
        if(dto.getStatus() == null) throw new InvalidArgumentException("status");

        BookshelfDAO dao = bookshelfDataSource.findById(dto.getBookshelfId())
                .orElse(null);

        if(dao == null) throw new BookshelfNotFoundException(dto.getBookshelfId());

        BookshelfItemDAO item = dao.getContent().stream()
                .filter(c -> c.getISBN13().equals(dto.getISBN13()))
                .findAny().get();

        item.setStatus(dto.getStatus());

        dao = bookshelfDataSource.save(dao);

        Bookshelf model = bookshelfMapper.toModel(dao);
        return bookshelfMapper.toDTO(model);
    }

    public BookshelfDTO removeBook(RemoveBookDTO dto) {
        if(dto == null) throw new InvalidArgumentException("dto");

        BookshelfDAO dao = bookshelfDataSource.findById(dto.getBookshelfId())
                .orElse(null);

        if(dao == null) throw new BookshelfNotFoundException(dto.getBookshelfId());

        BookshelfItemDAO item = dao.getContent().stream()
                .filter(c -> c.getISBN13().equals(dto.getISBN13()))
                .findAny().orElse(null);

        if(item == null) throw new BookNotFoundException(dto.getISBN13());

        dao.getContent().remove(item);

        dao = bookshelfDataSource.save(dao);

        Bookshelf model = bookshelfMapper.toModel(dao);
        return bookshelfMapper.toDTO(model);
    }
}
