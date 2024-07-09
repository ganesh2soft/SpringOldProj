package com.deeps.book.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deeps.book.entity.Book;
import com.deeps.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book savebook(Book book) {
    	System.out.println("Inside Book Save Method" + book);
        return bookRepository.save(book);
    }

    public Book findBookById(Long bookId) {
        System.out.println("Inside findBookById method. Id =" +bookId);
        return bookRepository.findByBookId(bookId);
    }
    
    public List<Book> getAllBooks() {
    	return bookRepository.findAll();
    }

}
