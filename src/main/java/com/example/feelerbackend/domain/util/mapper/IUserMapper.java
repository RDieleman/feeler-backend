package com.example.feelerbackend.domain.util.mapper;

import com.example.feelerbackend.domain.model.user.User;
import com.example.feelerbackend.domain.model.user.UserDAO;
import com.example.feelerbackend.domain.model.user.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserMapper {
    UserDTO toDTO(User model);
    UserDAO toDAO(User model);
    User toModel(UserDAO dao);
    User toModel(UserDTO dto);
}
