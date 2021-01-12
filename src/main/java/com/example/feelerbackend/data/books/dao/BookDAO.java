package com.example.feelerbackend.data.books.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDAO {
    private String title;
    private String title_long;
    private String isbn;
    private String isbn13;
    private String language;
    private String image;
    private ArrayList<String> subjects = new ArrayList<>();
}
