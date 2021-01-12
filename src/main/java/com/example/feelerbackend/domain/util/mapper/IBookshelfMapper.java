package com.example.feelerbackend.domain.util.mapper;

import com.example.feelerbackend.domain.model.bookshelf.Bookshelf;
import com.example.feelerbackend.domain.model.bookshelf.BookshelfDAO;
import com.example.feelerbackend.domain.model.bookshelf.BookshelfDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IBookshelfMapper {
    BookshelfDTO toDTO(Bookshelf model);
    Bookshelf toModel(BookshelfDAO dao);
    Bookshelf toModel(BookshelfDTO dto);
    BookshelfDAO toDAO(Bookshelf model);
}
