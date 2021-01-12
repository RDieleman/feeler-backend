package com.example.feelerbackend.data.users.dao;

import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookshelfItemDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    private String ISBN13;
    private Status status;
}
