package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.books.dao.BookDAO;
import com.example.feelerbackend.data.books.IBookDataSource;
import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.model.book.GetExploreResultDTO;
import com.example.feelerbackend.domain.util.mapper.IBookMapper;
import com.example.feelerbackend.web.api.exception.implementations.BookNotFoundException;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final IBookDataSource bookDataSource;
    private final IBookMapper bookMapper;
    private final MoodService moodService;

    @Value("${explore.result.size}")
    private int exploreResultSize;

    @Autowired
    public BookService(IBookDataSource bookDataSource, IBookMapper bookMapper, MoodService moodService) {
        this.bookDataSource = bookDataSource;
        this.bookMapper = bookMapper;
        this.moodService = moodService;
    }

    public BookDTO getBookByISBN(String ISBN){
        if(ISBN==null || ISBN.isBlank() || ISBN.isEmpty()) throw new InvalidArgumentException(ISBN);
        BookDAO dao = bookDataSource.getBookByISBN(ISBN);
        if(dao == null) throw new BookNotFoundException(ISBN);
        Book model = bookMapper.toModel(dao);

        return bookMapper.toDTO(model);
    }

    public List<BookDTO> getExploreResult(GetExploreResultDTO dto){
        List<BookDTO> books = new ArrayList<>();
        String subject = moodService.getSubjectFromMood(dto.getMood());

        for(BookDAO dao : bookDataSource.getBooksBySubject(dto.getPage(), exploreResultSize, subject)){
            Book b = bookMapper.toModel(dao);
            books.add(bookMapper.toDTO(b));
        }

        return books;
    }

}
