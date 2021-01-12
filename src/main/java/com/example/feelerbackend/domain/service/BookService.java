package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.dao.BookDAO;
import com.example.feelerbackend.data.resource.BookInfoResourceImpl;
import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.domain.model.User;
import com.example.feelerbackend.domain.util.mapper.BookMapper;
import com.example.feelerbackend.web.api.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    private final BookInfoResourceImpl bookInfoResource;
    private final BookMapper bookMapper;
    private final UserService userService;

    public BookService(BookInfoResourceImpl bookInfoResource, BookMapper bookMapper, UserService userService) {
        this.bookInfoResource = bookInfoResource;
        this.bookMapper = bookMapper;
        this.userService = userService;
    }

    public Book getBookByISBN(String ISBN){
        BookDAO dao = bookInfoResource.getBookInfoByISBN(ISBN);
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
