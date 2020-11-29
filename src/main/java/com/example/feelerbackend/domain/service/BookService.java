package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.model.ISBNType;
import com.example.feelerbackend.web.api.exception.BookNotFoundException;
import com.example.feelerbackend.web.api.exception.InvalidISBNException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book getBookByISBN(String ISBN){
        ISBNType type = getISBNType(ISBN);
        switch (type){
            case ISBN10:
                return getBookByISBN10(ISBN);
            case ISBN13:
            default:
                return getBookByISBN13(ISBN);
        }
    }

    private Book getBookByISBN10(String ISBN){
        throw new BookNotFoundException(ISBN);
    }

    private Book getBookByISBN13(String ISBN13){
        throw new BookNotFoundException(ISBN13);
    }

    private ISBNType getISBNType(String ISBN){
        String identifier = ISBN.substring(0, 3);

        switch (identifier){
            case "978":
                return ISBNType.ISBN10;
            case "979":
                return ISBNType.ISBN13;
            default:
                throw new InvalidISBNException(ISBN);
        }
    }
}
