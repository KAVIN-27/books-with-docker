package com.springboot_docker_tutorial.Books.service.impl;

import com.springboot_docker_tutorial.Books.domain.Book;
import com.springboot_docker_tutorial.Books.domain.BookEntity;
import com.springboot_docker_tutorial.Books.repositories.BookRepository;
import com.springboot_docker_tutorial.Books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean isBookExists(Book book) {
        return repository.existsById(book.getIsbn());
    }

    @Override
    public Book save(Book book) {
        final BookEntity bookEntity = bookToBookEntity(book);
        final BookEntity savedBookEntity = repository.save(bookEntity);
        return bookEntityToBook(savedBookEntity);
    }

    @Override
    public Optional<Book> findById(String isbn) {

        final Optional<BookEntity> foundBook = repository.findById(isbn);
        return foundBook.map(book -> bookEntityToBook(book));
    }


    private Book bookEntityToBook(BookEntity bookEntity){
        return Book.builder()
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .build();
    }

    private BookEntity bookToBookEntity(Book book){
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

}
