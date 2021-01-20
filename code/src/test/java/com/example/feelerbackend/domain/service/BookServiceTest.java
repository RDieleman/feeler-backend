package com.example.feelerbackend.domain.service;

import com.example.feelerbackend.data.books.IBookDataSource;
import com.example.feelerbackend.domain.model.Mood;
import com.example.feelerbackend.domain.model.book.Book;
import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.model.book.GetExploreResultDTO;
import com.example.feelerbackend.domain.util.mapper.IBookMapper;
import com.example.feelerbackend.web.api.exception.implementations.BookNotFoundException;
import com.example.feelerbackend.web.api.exception.implementations.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Value("${explore.result.size}")
    int size;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getBookByISBNWithNullThrowsInvalidArgumentException() {
        Throwable e = null;

        try{
            bookService.getBookByISBN(null);
        }catch (Throwable ex){
            e = ex;
        }

        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    public void getBookByISBNWithEmptyStringThrowsInvalidArgumentException(){
        Throwable e = null;

        try{
            bookService.getBookByISBN("");
        }catch (Throwable ex){
            e = ex;
        }

        assertTrue(e instanceof InvalidArgumentException);
    }

    @Test
    public void getBookByISBNWithNullResponseThrowsBookNotFoundException(){
        Throwable e = null;
        try{
            bookService.getBookByISBN("null");
        }catch (Throwable thrown){
            e = thrown;
        }

        assertTrue(e instanceof BookNotFoundException);
    }


    @Test
    public void getBookByISBNWithCorrectISBNFindsBookObject(){
        BookDTO book = bookService.getBookByISBN("testISBN");

        assertNotNull(book);
    }


    @Test
    public void getExploreResult() {

        GetExploreResultDTO dto = new GetExploreResultDTO();
        dto.setPage(1);
        dto.setMood(Mood.angry);

        List<BookDTO> books = bookService.getExploreResult(dto);

        assertNotNull(books);
        assertEquals(books.size(), size);
    }
}