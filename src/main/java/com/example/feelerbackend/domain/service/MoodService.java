package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Mood;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoodService {
    public ArrayList<String> getAvailableMoods(){
        ArrayList<String> values = new ArrayList<>();
        Mood[] moods = Mood.values();
        for(Mood mood: moods){
            values.add(mood.toString());
        }

        return values;
    }
}
