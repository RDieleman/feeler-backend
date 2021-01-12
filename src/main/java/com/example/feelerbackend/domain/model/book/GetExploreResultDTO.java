package com.example.feelerbackend.domain.model.book;

import com.example.feelerbackend.domain.model.Mood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetExploreResultDTO {
    private Mood mood;
    private int page;
}
