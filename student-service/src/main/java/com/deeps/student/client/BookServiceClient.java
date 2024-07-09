package com.deeps.student.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deeps.student.entity.Book;

@FeignClient(name="BOOK-SERVICE")
public interface BookServiceClient {
	
	
    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable Long id);

    @GetMapping("/api/books/allbooks")
    public List<Book> getAllBooks();
}
