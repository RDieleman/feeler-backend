package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.domain.service.MoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping(value = "/mood")
@Api(tags = "Moods")
public class MoodController {
    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    /**
     * Get all available mood values
     * @return A list of mood values
     */
    @ApiOperation(
            value = "Get a list of available mood values"
    )
    @ApiResponse(
            code=200, message="The list of available mood values has been returned."
    )
    @GetMapping
    public ResponseEntity<Mood[]> getAvailableMoods(){
        Mood[] resource = moodService.getAvailableMoods();
        return ResponseEntity.ok(resource);
    }
}
