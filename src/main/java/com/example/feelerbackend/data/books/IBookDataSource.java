package com.example.feelerbackend.data.books;

import com.example.feelerbackend.domain.model.book.BookDAO;

public interface IBookDataSource {
    BookDAO getBookInfoByISBN(String ISBN);
}
