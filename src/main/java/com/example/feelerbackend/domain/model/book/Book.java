package com.example.feelerbackend.domain.model.book;

import com.example.feelerbackend.domain.model.user.BookStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String ISBN;
    private String title;
    private String overview;
    private String imageUrl;
}
