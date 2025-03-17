package com.springboot_docker_tutorial.Books.controller;

import com.springboot_docker_tutorial.Books.domain.Book;
import com.springboot_docker_tutorial.Books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody Book book){
        book.setIsbn(isbn);

        final boolean isBookExists = bookService.isBookExists(book);
        final Book savedBook = bookService.save(book);

        if(isBookExists){
            return new ResponseEntity<Book>(savedBook, HttpStatus.OK);

        }else {
            return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
        }

    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> retrieveBook(@PathVariable("id") String isbn){
        final Optional<Book> foundBook = bookService.findById(isbn);
        return  foundBook.map(
                book -> new ResponseEntity<Book>(book,HttpStatus.OK)
        ).orElse(new ResponseEntity<Book>(HttpStatus.NOT_FOUND));
        
    }

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> retrieveAllBooks(@PathVariable("id") String isbn){
        return new ResponseEntity<List<Book>>(bookService.listBook(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/books/{isbn}")
    ResponseEntity deleteBook(@PathVariable("id") String isbn){
        bookService.deleteBookById(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
