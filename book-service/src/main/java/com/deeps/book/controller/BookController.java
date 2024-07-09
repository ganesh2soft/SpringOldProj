package com.deeps.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.deeps.book.entity.Book;
import com.deeps.book.service.BookService;




@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public Book savebook(@RequestBody Book book) {
        System.out.println("Inside savebook method of bookController");
        return  bookService.savebook(book);
    }

    @GetMapping("/{id}")
    public Book findbookById(@PathVariable("id") Long bookId) {
    	System.out.println("Inside findbookById method of bookController");
        return bookService.findBookById(bookId);
    }
    
    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
    	return bookService.getAllBooks();
    }

}
