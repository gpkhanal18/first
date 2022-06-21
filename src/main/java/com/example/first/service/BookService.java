package com.example.first.service;

import com.example.first.model.Book;
import com.example.first.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List getAllBooks() {
        List books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book getBook(int id) {
        return (Book) bookRepository.findById(id).orElseGet(Book::new);
    }

    public void addBook(Book whiskey) {
        bookRepository.save(whiskey);
    }

    public void updateBook(String id, Book whiskey) {
        bookRepository.save(whiskey);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

}