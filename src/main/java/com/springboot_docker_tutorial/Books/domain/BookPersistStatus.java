package com.springboot_docker_tutorial.Books.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookPersistStatus {

    private boolean created;

    private Book book;
}