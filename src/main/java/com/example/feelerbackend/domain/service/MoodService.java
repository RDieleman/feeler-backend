package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.web.api.exception.implementations.InvalidMoodException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoodService {

    public Mood[] getAvailableMoods(){
        return Mood.values();
    }

    public String getSubjectFromMood(Mood mood){
        return "horror"; //todo: implement mood to subject convert logic
    }
}
