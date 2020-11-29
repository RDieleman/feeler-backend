package com.example.feelerbackend.domain.util.mapper;

import com.example.feelerbackend.data.dao.BookDAO;
import com.example.feelerbackend.domain.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book mapBook(BookDAO dao){
        Book book = new Book();
        book.setImage(dao.getImage());
        book.setIsbn(dao.getIsbn());
        book.setIsbn13(dao.getIsbn13());
        book.setLanguage(dao.getLanguage());
        book.setTitle(dao.getTitle());
        book.setTitle_long(dao.getTitle_long());
        book.setSubjects(dao.getSubjects());
        return book;
    }
}
