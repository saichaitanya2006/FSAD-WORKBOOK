package com.klu.library.controller;

import com.klu.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 3. /count
    @GetMapping("/count")
    public int countBooks() {
        return 100;
    }

    // 4. /price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java", "Spring Boot", "Python", "Cloud Computing");
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id) {
        return "Book details for ID : " + id;
    }

    // 7. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book : " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by : " + name;
    }

    // 9. /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book Added Successfully";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}