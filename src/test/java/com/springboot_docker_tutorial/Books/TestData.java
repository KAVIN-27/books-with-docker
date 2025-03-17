package com.springboot_docker_tutorial.Books;

import com.springboot_docker_tutorial.Books.domain.Book;
import com.springboot_docker_tutorial.Books.domain.BookEntity;

public class TestData {

    private TestData() {}

    public static Book testBook() {
        return Book.builder().isbn("02345678").author("Virginia Woolf").title("The Waves").build();
    }

    public static BookEntity testBookEntity() {
        return BookEntity.builder()
                .isbn("02345678")
                .author("Virginia Woolf")
                .title("The Waves")
                .build();
    }
}
