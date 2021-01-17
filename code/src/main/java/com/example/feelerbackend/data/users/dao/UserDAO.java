package com.example.feelerbackend.data.users.dao;

import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import com.example.feelerbackend.domain.model.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BookshelfDAO bookshelf = new BookshelfDAO();
}
