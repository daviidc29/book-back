package com.bookai.controller;

import com.bookai.domain.BookDTO;
import com.bookai.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> search(@RequestParam String q) {
        return ResponseEntity.ok(bookService.searchBooks(q));
    }
}