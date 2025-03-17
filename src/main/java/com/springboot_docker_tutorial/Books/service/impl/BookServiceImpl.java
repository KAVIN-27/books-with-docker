package com.springboot_docker_tutorial.Books.service.impl;

import com.springboot_docker_tutorial.Books.domain.Book;
import com.springboot_docker_tutorial.Books.domain.BookEntity;
import com.springboot_docker_tutorial.Books.repositories.BookRepository;
import com.springboot_docker_tutorial.Books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j

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

    @Override
    public void deleteBookById(String isbn) {
        try {
            repository.deleteById(isbn);
        }catch (final EmptyResultDataAccessException ex){
            log.debug("Attempted to delete non-existing book",ex);
        }
    }

    @Override
    public List<Book> listBook() {
     final List<BookEntity> foundBook = repository.findAll();
     return foundBook.stream()
             .map(this::bookEntityToBook)
             .collect(Collectors.toList());
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
