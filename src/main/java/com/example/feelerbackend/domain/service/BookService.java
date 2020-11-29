package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.dao.BookDAO;
import com.example.feelerbackend.data.resource.BookInfoResourceImpl;
import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.util.mapper.BookMapper;
import com.example.feelerbackend.web.api.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookInfoResourceImpl bookInfoResource;
    private final BookMapper bookMapper;

    public BookService(BookInfoResourceImpl bookInfoResource, BookMapper bookMapper) {
        this.bookInfoResource = bookInfoResource;
        this.bookMapper = bookMapper;
    }

    public Book getBookByISBN(String ISBN){
        BookDAO dao = bookInfoResource.getBookInfoByISBN(ISBN);
        if(dao == null) throw new BookNotFoundException(ISBN);

        return bookMapper.mapBook(dao);
    }
}
