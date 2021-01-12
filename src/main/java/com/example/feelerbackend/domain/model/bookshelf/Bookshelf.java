package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookshelf {
    Map<Book, Status> content;
}
