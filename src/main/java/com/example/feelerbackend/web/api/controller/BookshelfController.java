package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.bookshelf.AddBookDTO;
import com.example.feelerbackend.domain.model.bookshelf.BookshelfDTO;
import com.example.feelerbackend.domain.model.bookshelf.RemoveBookDTO;
import com.example.feelerbackend.domain.model.bookshelf.UpdateBookDTO;
import com.example.feelerbackend.domain.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping("bookshelf")
public class BookshelfController {
    private final BookshelfService bookshelfService;

    @Autowired
    public BookshelfController(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    @PutMapping
    public ResponseEntity<BookshelfDTO> addBookToShelf(@RequestBody AddBookDTO dto){
        BookshelfDTO resource = bookshelfService.addBook(dto);
        return ResponseEntity.ok(resource);
    }

    @PatchMapping
    public ResponseEntity<BookshelfDTO> updateBookshelfBookStatus(@RequestBody UpdateBookDTO dto){
        BookshelfDTO resource = bookshelfService.updateBook(dto);
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping
    public ResponseEntity<BookshelfDTO> removeBookFromShelf(@RequestBody RemoveBookDTO dto){
        BookshelfDTO resource = bookshelfService.removeBook(dto);
        return ResponseEntity.ok(resource);
    }
}
