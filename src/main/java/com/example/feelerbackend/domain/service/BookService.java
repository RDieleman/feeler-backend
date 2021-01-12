package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.books.dao.BookDAO;
import com.example.feelerbackend.data.books.source.IBookDataSource;
import com.example.feelerbackend.data.books.source.implementations.BookDataSourceISBNdb;
import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.domain.model.User;
import com.example.feelerbackend.domain.util.mapper.BookMapper;
import com.example.feelerbackend.web.api.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    private final IBookDataSource bookDataSource;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(IBookDataSource bookDataSource, BookMapper bookMapper) {
        this.bookDataSource = bookDataSource;
        this.bookMapper = bookMapper;
    }

    public Book getBookByISBN(String ISBN){
        BookDAO dao = bookDataSource.getBookInfoByISBN(ISBN);
        if(dao == null) throw new BookNotFoundException(ISBN);

        return bookMapper.mapBook(dao);
    }

    public ArrayList<Book> getRecommendationsByMood(int amount, Mood mood, User user){
        List<String> wantToRead = user.getWant_to_read_list();
        Collections.shuffle(wantToRead);
        ArrayList<Book> recommendations = new ArrayList<>();
        int count = 0;
        for(String isbn : wantToRead){
            if(count >= amount){
                break;
            }
            try{
                recommendations.add(getBookByISBN(isbn));
                count++;
            }
            catch (Exception ex){
                System.out.print(ex);
            }
        }

        return recommendations;
    }

}
