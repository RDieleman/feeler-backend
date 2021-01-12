package com.example.feelerbackend.data.users.repositories;

import com.example.feelerbackend.data.users.dao.BookshelfDAO;
import org.springframework.data.repository.CrudRepository;

public interface IBookshelfRepository extends CrudRepository<BookshelfDAO, Long> {
}
