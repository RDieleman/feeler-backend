package com.example.feelerbackend.domain.model.bookshelf;

import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBookDTO {
    long bookshelfId;
    String ISBN13;
    Status status;
}
