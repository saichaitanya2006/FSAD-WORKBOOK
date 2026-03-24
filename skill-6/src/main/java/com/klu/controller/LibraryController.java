package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1 Welcome endpoint
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    // 2 Count endpoint
    @GetMapping("/count")
    public int getBookCount() {
        return 100;
    }

    // 3 Price endpoint
    @GetMapping("/price")
    public double getBookPrice() {
        return 499.99;
    }

    // 4 Get list of book titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Data Structures");

        return books;
    }

    // 5 Get book by ID using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book Details for ID: " + id;
    }

    // 6 Search using request parameter
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book titled: " + title;
    }

    // 7 Author endpoint
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 8 Add Book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9 View all books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}