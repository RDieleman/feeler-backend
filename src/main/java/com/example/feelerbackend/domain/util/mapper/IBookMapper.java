package com.example.feelerbackend.domain.util.mapper;

import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.book.BookDAO;
import com.example.feelerbackend.domain.model.book.BookDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IBookMapper {
    BookDAO toDAO(Book model);
    BookDTO toDTO(Book model);
    Book toModel(BookDAO dao);
    Book toModel(BookDTO dto);
}
