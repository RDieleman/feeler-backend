package com.example.feelerbackend.domain.model.bookshelf.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookshelfItem {
    long id;
    String ISBN13;
    Status status;
}
