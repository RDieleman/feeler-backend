package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.book.BookDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveBookDAO {
    String userId;
    BookDAO book;
}
