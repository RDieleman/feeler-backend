package com.example.feelerbackend.domain.model.user;

import com.example.feelerbackend.domain.model.bookshelf.BookshelfDAO;
import lombok.*;

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
