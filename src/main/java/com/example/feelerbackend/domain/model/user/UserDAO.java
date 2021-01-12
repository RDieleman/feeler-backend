package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.book.BookDAO;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    private String id;
    private String name;
    private Map<BookDAO, BookStatus> bookInfo = new HashMap<>();
}
