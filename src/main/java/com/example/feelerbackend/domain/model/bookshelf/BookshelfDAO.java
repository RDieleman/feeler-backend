package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.book.BookDAO;
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
public class BookshelfDAO {
    private Map<BookDAO, Status> content = new HashMap<>();
}
