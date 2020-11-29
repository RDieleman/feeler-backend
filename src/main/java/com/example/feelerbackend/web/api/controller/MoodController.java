package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.service.MoodService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping(value = "/moods")
    public ResponseEntity<ArrayList<String>> getAvailableMoods(){
        ArrayList<String> moods = moodService.getAvailableMoods();

        return ResponseEntity.ok(moods);
    }
}
