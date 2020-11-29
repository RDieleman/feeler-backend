package com.example.feelerbackend.data.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}