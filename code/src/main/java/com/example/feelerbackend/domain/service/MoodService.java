package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import com.example.feelerbackend.web.api.exception.implementations.InvalidMoodException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoodService {

    public Mood[] getAvailableMoods(){
        return Mood.values();
    }

    public String getSubjectFromMood(Mood mood){
        if(mood == null) throw new InvalidArgumentException("mood");

        switch (mood){
            case angry:
                return "biography biographies autobiography essay true-crime";
            case happy:
                return "self-help cookbook food cooking short-story romance";
            case scared:
                return "true-crime horror suspense thriller";
            case surprised:
                return "thriller detective";
            default:
                return " ";
        }
    }
}
