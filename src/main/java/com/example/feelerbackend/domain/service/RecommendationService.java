package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.model.Mood;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    private BookService bookService;

    public RecommendationService(BookService bookService){
        this.bookService = bookService;
    }

    public List<Book> getRecommendations(int amount, Mood mood){
        return null;
    }
}
