package com.example.feelerbackend.web.api.controller;

import com.example.feelerbackend.domain.model.bookshelf.*;
import com.example.feelerbackend.domain.service.BookshelfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"${api.cors.origin}"})
@RequestMapping("/bookshelf")
@Api(tags = "Bookshelves")
public class BookshelfController {
    private final BookshelfService bookshelfService;

    @Autowired
    public BookshelfController(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    /**
     * Get a user's bookshelf
     * @param dto   Object containing the users info needed to retrieve the bookshelf
     * @return  The user's bookshelf
     */
    @ApiOperation(
            value = "Get a user's bookshelf"
    )
    @ApiResponse(
            code=200, message="The bookshelf has been returned."
    )
    @GetMapping
    public ResponseEntity<BookshelfDTO> getBookshelf(@RequestBody GetBookshelfDTO dto){
        BookshelfDTO resource = bookshelfService.getBookshelf(dto);
        return ResponseEntity.ok(resource);
    }

    /**
     * Add a new book to a user's bookshelf
     * @param dto Object containing info about the book and the user
     * @return The updated bookshelf
     */
    @ApiOperation(
            value = "Add a new book to a user's bookshelf"
    )
    @ApiResponse(
            code=200, message="The book has been added to the bookshelf and the updated bookshelf has been returned."
    )
    @PutMapping
    public ResponseEntity<BookshelfDTO> addBookToShelf(@RequestBody AddBookDTO dto){
        BookshelfDTO resource = bookshelfService.addBook(dto);
        return ResponseEntity.ok(resource);
    }

    /**
     * Update the reading status of a book in the user's bookshelf
     * @param dto Object containing info about the book and the user and the new status
     * @return  The updated bookshelf
     */
    @ApiOperation(
            value = "Update the reading status of a book on the user's bookshelf"
    )
    @ApiResponse(
            code=200, message="The status of the provided book has been updated and the updated bookshelf has been returned."
    )
    @PatchMapping
    public ResponseEntity<BookshelfDTO> updateBookshelfBookStatus(@RequestBody UpdateBookDTO dto){
        BookshelfDTO resource = bookshelfService.updateBook(dto);
        return ResponseEntity.ok(resource);
    }

    /**
     * Remove a book from the user's bookshelf
     * @param dto   Object containing info about the user and the book that needs to be removed
     * @return  The updated bookshelf
     */
    @ApiOperation(
            value = "Remove a book from the user's bookshelf"
    )
    @ApiResponse(
            code=200, message="The book has been removed from the bookshelf and the updated bookshelf has been returned."
    )

    @DeleteMapping
    public ResponseEntity<BookshelfDTO> removeBookFromShelf(@RequestBody RemoveBookDTO dto){
        BookshelfDTO resource = bookshelfService.removeBook(dto);
        return ResponseEntity.ok(resource);
    }
}
