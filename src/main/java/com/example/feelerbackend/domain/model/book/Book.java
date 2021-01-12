package com.example.feelerbackend.domain.model.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;
    private String title_long;
    private String isbn;
    private String isbn13;
    private String language;
    private String image;
    private ArrayList<String> subjects = new ArrayList<>();
}
