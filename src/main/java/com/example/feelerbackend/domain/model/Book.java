package com.example.feelerbackend.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Book {

    private String title;
    private String title_long;
    private String isbn;
    private String isbn13;
    private String language;
    private String image;
    private ArrayList<String> authors;
    private ArrayList<String> subjects;

}
