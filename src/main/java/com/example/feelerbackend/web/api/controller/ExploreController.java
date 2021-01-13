package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.book.BookDTO;
import com.example.feelerbackend.domain.model.book.GetExploreResultDTO;
import com.example.feelerbackend.domain.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping("/explore")
@Api(tags = "Exploring")
public class ExploreController {
    private final BookService bookService;

    public ExploreController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Get a list of books for the user to explore by providing a mood
     * @param dto Object containing info about the mood and the specific page that needs to be returned
     * @return  The requested page of books
     */
    @ApiOperation(
            value = "Request a list of books by mood for the user to explore"
    )
    @ApiResponse(
            code=200, message="The requested page of books has been returned."
    )
    @PostMapping
    public ResponseEntity<List<BookDTO>> getExploreResult(@RequestBody GetExploreResultDTO dto){
        List<BookDTO> resource = bookService.getExploreResult(dto);
        return ResponseEntity.ok(resource);
    }
}
