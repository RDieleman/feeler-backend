package com.example.feelerbackend.domain.model.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String ISBN13;
    private String title;
    private String overview;
    private String imageUrl;
}
