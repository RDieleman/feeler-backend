package com.example.feelerbackend.data.books.source;

import com.example.feelerbackend.data.books.dao.BookDAO;

public interface IBookDataSource {
    BookDAO getBookInfoByISBN(String ISBN);
}
