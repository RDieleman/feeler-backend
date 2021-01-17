package com.example.feelerbackend.domain.model.book;

import com.example.feelerbackend.domain.model.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetExploreResultDTO {
    private Mood mood;
    private int page;
}
