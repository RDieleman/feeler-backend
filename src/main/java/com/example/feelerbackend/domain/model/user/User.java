package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.bookshelf.Bookshelf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private Bookshelf bookshelf;
}
