package com.example.feelerbackend.data.users;

import com.example.feelerbackend.data.users.dao.BookshelfItemDAO;
import com.example.feelerbackend.data.users.dao.UserDAO;
import com.example.feelerbackend.data.users.repositories.IUserRepository;
import com.example.feelerbackend.domain.model.bookshelf.AddBookDTO;
import com.example.feelerbackend.domain.model.user.UserDTO;
import com.example.feelerbackend.domain.service.BookshelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "test", "prod"})
public class DataLoader implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(DataLoader.class);
    IUserRepository userDataSource;
    BookshelfService bookshelfService;

    @Autowired
    public DataLoader(IUserRepository userDataSource, BookshelfService bookshelfService) {
        this.userDataSource = userDataSource;
        this.bookshelfService = bookshelfService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserDAO user = createMockUser();
        //addMockBooks(user);
    }

    private UserDAO createMockUser(){
        logger.info("Creating mock user...");
        UserDAO mockUser = new UserDAO();
        mockUser.setName("Ruben");

        return userDataSource.save(mockUser);
    }

    private void addMockBooks(UserDAO user){
        logger.info("Adding mock book to shelf...");
        AddBookDTO dto = new AddBookDTO();
        dto.setBookshelfId(user.getBookshelf().getId());
        dto.setISBN13("9781444736991");

        bookshelfService.addBook(dto);
    }
}
