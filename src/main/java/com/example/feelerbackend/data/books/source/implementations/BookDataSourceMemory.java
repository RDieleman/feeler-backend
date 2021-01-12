package com.example.feelerbackend.data.books.source.implementations;

import com.example.feelerbackend.data.books.dao.BookDAO;
import com.example.feelerbackend.data.books.source.BookDataSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Profile("test")
public class BookDataSourceMemory extends BookDataSource {

    @Override
    public BookDAO getBookInfoByISBN(String ISBN) {
        return new BookDAO(
                "title",
                "title_long",
                "isbn10",
                "isbn13",
                "lang",
                "https://2.bp.blogspot.com/-MEkIz1Bld0c/T_4oRfvREPI/AAAAAAAAA8k/wZHwb6kUPlw/s1600/blank+book+cover.jpg",
                new ArrayList<>()
        );
    }
}
