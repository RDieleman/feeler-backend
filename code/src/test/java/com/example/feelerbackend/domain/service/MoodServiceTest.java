package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoodServiceTest {

    @Autowired
    private MoodService moodService;

    @Test
    public void getAvailableMoodsTest(){
        //execute
        Mood[] moods = moodService.getAvailableMoods();

        //assert
        assertNotNull(moods);
    }

    @Test
    public void getSubjectFromMoodWithNullValueThrowsInvalidArgumentExceptionTest(){
        //setup
        Throwable e = null;

        //execute
        try{
            moodService.getSubjectFromMood(null);
        }catch (Throwable thrown){
            e = thrown;
        }

        //assert
        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    public void getSubjectFromMoodsWithValidValueReturnsSubject(){
        //execute
        String subject = moodService.getSubjectFromMood(Mood.scared);

        //assert

        //check for value
        assertNotNull(subject);
        
        //check for empty or blank values
        assertFalse(subject.isBlank() || subject.isEmpty());

    }


}