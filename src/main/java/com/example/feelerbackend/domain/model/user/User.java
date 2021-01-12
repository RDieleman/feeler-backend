package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.bookshelf.Bookshelf;
import com.example.feelerbackend.domain.model.bookshelf.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Bookshelf bookshelf;
}
