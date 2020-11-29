package com.example.feelerbackend.data.resource;

import com.example.feelerbackend.data.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserInfoResourceImpl implements UserInfoResource {
    @Override
    public UserDAO getUserInfoById(String id) {
        //todo: Implement GoodReads with oath
        UserDAO mockUser = new UserDAO();
        mockUser.setId(id);
        mockUser.setName("Ruben");
        ArrayList<String> books = new ArrayList<>();
        books.add("9780345015339");
        books.add("1474605737");
        books.add("0545010225");
        books.add("9780439655484");
        books.add("9780439064866");
        books.add("0439358078");
        books.add("9780345296061");
        books.add("9780345240347");
        books.add("0345391802");
        books.add("9780374404147");
        books.add("9780007119318");
        books.add("9781420925531");
        books.add("9780385732550");
        books.add("9781791392796");
        books.add("9780735220683");
        books.add("9780140439076");
        books.add("9780590554671");
        books.add("9780439139595");
        books.add("9780590353403");
        books.add("9780439784542");
        mockUser.setWant_to_read_list(books);
        return mockUser;
    }
}
