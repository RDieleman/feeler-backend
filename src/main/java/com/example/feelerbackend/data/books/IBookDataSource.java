package com.example.feelerbackend.data.books;

import com.example.feelerbackend.domain.model.book.BookDAO;

import java.util.List;

public interface IBookDataSource {
    BookDAO getBookByISBN(String ISBN);
    List<BookDAO> getBooksBySubject(int page, int size, String subject);
}
