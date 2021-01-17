package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.bookshelf.BookshelfDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private BookshelfDTO bookshelf;
}
