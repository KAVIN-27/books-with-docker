package com.springboot_docker_tutorial.Books.repositories;

import com.springboot_docker_tutorial.Books.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,String>, PagingAndSortingRepository<BookEntity,String> {

}
