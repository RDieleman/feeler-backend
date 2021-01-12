package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.Book;
import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.domain.model.User;
import com.example.feelerbackend.domain.service.BookService;
import com.example.feelerbackend.domain.service.MoodService;
import com.example.feelerbackend.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
public class RecommendationController {
    private final MoodService moodService;
    private final BookService bookService;
    private final UserService userService;

    public RecommendationController(MoodService moodService, BookService bookService, UserService userService) {
        this.moodService = moodService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping(value = "/recommendation/{moodValue}/{userId}")
    public ResponseEntity<ArrayList<Book>> getRecommendations(
            @PathVariable String moodValue, @PathVariable String userId){
        User user = userService.getUserById(userId);
        Mood mood = moodService.getMoodFromString(moodValue);
        ArrayList<Book> recommendations = bookService.getRecommendationsByMood(10, mood, user);

        return ResponseEntity.ok(recommendations);
    }
}
