package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.book.BookDAO;
import com.example.feelerbackend.domain.model.bookshelf.BookshelfDAO;
import com.example.feelerbackend.domain.model.bookshelf.Status;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    private String id;
    private String name;
    private BookshelfDAO bookshelf;
}
