package com.example.feelerbackend.domain.model.user;

import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    private String id;
    private String name;
    private ArrayList<String> want_to_read_list = new ArrayList<>();
}
