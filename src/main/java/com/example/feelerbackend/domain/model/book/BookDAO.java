package com.example.feelerbackend.domain.model.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDAO {
    @JsonProperty("isbn13")
    private String ISBN13;

    @JsonProperty("title_long")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("image")
    private String imageUrl;
}
