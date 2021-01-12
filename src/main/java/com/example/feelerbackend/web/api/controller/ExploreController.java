package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.model.book.GetExploreResultDTO;
import com.example.feelerbackend.domain.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping("explore")
public class ExploreController {
    private final BookService bookService;

    public ExploreController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getExploreResult(@RequestBody GetExploreResultDTO dto){
        List<BookDTO> resource = bookService.getExploreResult(dto);
        return ResponseEntity.ok(resource);
    }
}
