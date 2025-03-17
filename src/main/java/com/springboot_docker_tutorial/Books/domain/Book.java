package com.springboot_docker_tutorial.Books.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Book {

    private String isbn;

    private String title;

    private  String author;
}
