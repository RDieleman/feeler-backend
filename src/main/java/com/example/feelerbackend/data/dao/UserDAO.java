package com.example.feelerbackend.data.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    private String id;
    private String name;
    private ArrayList<String> want_to_read_list = new ArrayList<>();
}
