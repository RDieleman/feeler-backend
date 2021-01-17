package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.Mood;
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
     * Get a page of books with a specific mood
     * @param mood the mood used to search for book genres
     * @param page the page of the result
     * @return A list of books
     */
    @ApiOperation(
            value = "Request a list of books by mood for the user to explore"
    )
    @ApiResponse(
            code=200, message="The requested page of books has been returned."
    )
    @GetMapping(value = "/{mood}/{page}")
    public ResponseEntity<List<BookDTO>> getExploreResult(@PathVariable Mood mood, @PathVariable int page){
        GetExploreResultDTO dto = new GetExploreResultDTO();
        dto.setMood(mood);
        dto.setPage(page);

        List<BookDTO> resource = bookService.getExploreResult(dto);
        return ResponseEntity.ok(resource);
    }
}
