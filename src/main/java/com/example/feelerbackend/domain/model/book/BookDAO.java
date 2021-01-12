package com.example.feelerbackend.domain.model.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
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
