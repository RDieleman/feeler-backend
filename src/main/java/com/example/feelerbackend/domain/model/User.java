package com.example.feelerbackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private ArrayList<String> want_to_read_list = new ArrayList<>();
}
