package com.example.feelerbackend.data.books.source;

import com.example.feelerbackend.data.DataSource;

public abstract class BookDataSource extends DataSource implements IBookDataSource{
    public BookDataSource() {
        super("BookDataSource");
    }
}
