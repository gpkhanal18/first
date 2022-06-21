package com.example.first.controller;

import com.example.first.model.Book;
import com.example.first.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public List getAllBooks() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return bookservice.getBook(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        bookservice.addBook(book);
        return bookservice.getBook(book.getId());
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        bookservice.updateBook(id, book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int bookId) {
        bookservice.deleteBook(bookId);
        return "successfully deleted bookid " + bookId;
    }
}