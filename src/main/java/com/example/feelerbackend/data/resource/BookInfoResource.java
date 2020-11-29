package com.example.feelerbackend.data.resource;


import com.example.feelerbackend.data.dao.BookDAO;

public interface BookInfoResource {
    BookDAO getBookInfoByISBN(String ISBN);
}
