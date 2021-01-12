package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.book.BookDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddBookDTO {
    private String userId;
    private String ISBN13;
}
