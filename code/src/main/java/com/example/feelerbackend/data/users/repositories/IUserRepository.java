package com.example.feelerbackend.data.users.repositories;

import com.example.feelerbackend.data.users.dao.UserDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserDAO, Long> {
}
