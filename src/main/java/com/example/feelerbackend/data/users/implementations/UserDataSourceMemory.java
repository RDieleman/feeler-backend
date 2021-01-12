package com.example.feelerbackend.data.users.implementations;

import com.example.feelerbackend.data.users.UserDataSource;
import com.example.feelerbackend.domain.model.user.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Profile({"test", "prod", "dev"})
public class UserDataSourceMemory extends UserDataSource {
    List<UserDAO> users = new ArrayList<>();

    public UserDataSourceMemory(){
        storeNewUser("1", "ruben");
    }

    @Override
    public UserDAO storeNewUser(String id, String name) {

        UserDAO user = new UserDAO(
                id,
                name,
                new HashMap<>()
        );

        users.add(user);

        return user;
    }

    @Override
    public UserDAO getUserById(String id) {
        return users.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
