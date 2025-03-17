package com.springboot_docker_tutorial.Books.service;

import com.springboot_docker_tutorial.Books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    boolean isBookExists(Book book);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    void deleteBookById(String isbn);

    List<Book> listBook();
}
