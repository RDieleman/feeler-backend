package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.users.dao.UserDAO;
import com.example.feelerbackend.data.users.repositories.IBookshelfRepository;
import com.example.feelerbackend.data.users.repositories.IUserRepository;
import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.model.bookshelf.item.Status;
import com.example.feelerbackend.web.api.exception.implementations.BookshelfNotFoundException;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookshelfServiceTest {

    @Autowired
    BookshelfService bookshelfService;
    @Autowired
    IUserRepository userRepository;

    private String username = "testname";
    private UserDAO mockUser;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        UserDAO user = new UserDAO();
        user.setName(username);

        mockUser = userRepository.save(user);
    }

    @Test
    void getBookshelfWithNonExistingIdThrowsBookshelfNotFoundException() {
        //Setup
        GetBookshelfDTO dto = new GetBookshelfDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId() + 10);
        Throwable e = null;

        //Execute
        try{
            bookshelfService.getBookshelf(dto);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert

        //Check exception type
        assertTrue(e instanceof BookshelfNotFoundException);
    }

    @Test
    void getBookshelfWithNullThrowsInvalidArgumentException() {

        //Setup
        Throwable e = null;

        //Execute
        try{
            bookshelfService.getBookshelf(null);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert
        //Check exception type
        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    void getBookshelfWithValidIdReturnsBookshelf() {
        //Setup
        GetBookshelfDTO dto = new GetBookshelfDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId());

        //Execute
        BookshelfDTO bookshelf = bookshelfService.getBookshelf(dto);

        //Assert
        //Check if bookshelf was returned
        assertNotNull(bookshelf);

        //Check if correct bookshelf was returned
        assertEquals(bookshelf.getId(), dto.getBookshelfId());
    }

    @Test
    void addBookWithNullThrowsInvalidArgumentException() {
        //Setup
        Throwable e = null;

        //Execute
        try{
            bookshelfService.addBook(null);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert
        //Check exception type
        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    void addBookToNonExistingBookshelfThrowsBookshelfNotFoundException(){
        //setup
        AddBookDTO dto = new AddBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId() + 10);
        dto.setISBN13("testISBN");

        Throwable e = null;

        //execute
        try{
            bookshelfService.addBook(dto);
        }catch (Throwable thrown){
            e = thrown;
        }

        //assert
        assertTrue(e instanceof BookshelfNotFoundException);
    }

    @Test
    void addBookWithValidObjectReturnsUpdatedBookshelf(){
        //Setup
        AddBookDTO dto = new AddBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId());
        dto.setISBN13("testISBN");


        //execute
        BookshelfDTO bookshelf = bookshelfService.addBook(dto);

        //Assert

        //Check if book returned
        assertNotNull(bookshelf);

        //Check if a book was added to the shelf
        assertNotEquals(bookshelf.getContent().size(), 0);

        //Check if isbn was correctly added
        assertEquals(bookshelf.getContent().get(0).getISBN13(), dto.getISBN13());

        //Check if status of new book is set as unread
        assertEquals(bookshelf.getContent().get(0).getStatus(), Status.UNREAD);
    }

    @Test
    void updateBookWithValidObjectReturnsUpdatedBookshelf() {
        //Setup
        AddBookDTO bookDTO = new AddBookDTO();
        bookDTO.setISBN13("testISBN");
        bookDTO.setBookshelfId(mockUser.getBookshelf().getId());

        bookshelfService.addBook(bookDTO);

        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId());
        dto.setISBN13("testISBN");
        dto.setStatus(Status.READ);

        //execute
        BookshelfDTO bookshelf = bookshelfService.updateBook(dto);

        //Assert

        //Check if book returned
        assertNotNull(bookshelf);

        //Check if status of new book is set as read
        assertEquals(bookshelf.getContent().get(0).getStatus(), Status.READ);
    }

    @Test
    void updateBookToNonExistingBookshelfThrowsBookshelfNotFoundException(){
        //setup
        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId() + 10);
        dto.setISBN13("testISBN");
        dto.setStatus(Status.READ);

        Throwable e = null;

        //execute
        try{
            bookshelfService.updateBook(dto);
        }catch (Throwable thrown){
            e = thrown;
        }

        //assert
        assertTrue(e instanceof BookshelfNotFoundException);
    }

    @Test
    void updateBookWithNullThrowsInvalidArgumentException() {
        //Setup
        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId() + 10);
        dto.setISBN13("testISBN");
        dto.setStatus(null);

        Throwable e = null;

        //Execute
        try{
            bookshelfService.updateBook(dto);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert
        //Check exception type
        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    void updateBookWithNullStatusThrowsInvalidArgumentException() {

        //Setup
        Throwable e = null;

        //Execute
        try{
            bookshelfService.updateBook(null);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert
        //Check exception type
        assertTrue(e instanceof InvalidArgumentException);
    }


    @Test
    void removeBookFromNonExistingBookshelfThrowsBookshelfNotFoundException(){
        //setup
        RemoveBookDTO dto = new RemoveBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId() + 10);
        dto.setISBN13("testISBN");

        Throwable e = null;

        //execute
        try{
            bookshelfService.removeBook(dto);
        }catch (Throwable thrown){
            e = thrown;
        }

        //assert
        assertTrue(e instanceof BookshelfNotFoundException);
    }

    @Test
    void removeBookWithValidObjectReturnsUpdatedBookshelf(){
        //Setup
        AddBookDTO bookDTO = new AddBookDTO();
        bookDTO.setISBN13("testISBN");
        bookDTO.setBookshelfId(mockUser.getBookshelf().getId());

        bookshelfService.addBook(bookDTO);

        RemoveBookDTO dto = new RemoveBookDTO();
        dto.setBookshelfId(mockUser.getBookshelf().getId());
        dto.setISBN13("testISBN");


        //execute
        BookshelfDTO bookshelf = bookshelfService.removeBook(dto);

        //Assert

        //Check if bookshelf returned
        assertNotNull(bookshelf);

        //Check if a book was removed from the shelf
        assertEquals(bookshelf.getContent().size(), 0);
    }

    @Test
    void removeBookshelfWithNullThrowsInvalidArgumentException() {

        //Setup
        Throwable e = null;

        //Execute
        try{
            bookshelfService.getBookshelf(null);
        }catch (Throwable thrown){
            e = thrown;
        }

        //Assert
        //Check exception type
        assertTrue(e instanceof InvalidArgumentException);
    }
}