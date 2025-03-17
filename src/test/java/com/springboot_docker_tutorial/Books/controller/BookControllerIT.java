//package com.springboot_docker_tutorial.Books.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.springboot_docker_tutorial.Books.TestData;
//import com.springboot_docker_tutorial.Books.domain.Book;
//import com.springboot_docker_tutorial.Books.service.BookService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@ExtendWith(MockitoExtension.class)
//public class BookControllerIT {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired private BookService bookService;
//
//    @Test
//    public void testThatBookIsSaved() throws Exception {
//        final Book book = TestData.testBook();
//        final ObjectMapper objectMapper = new ObjectMapper();
//        final String bookJson = objectMapper.writeValueAsString(book);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/books/"+book.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(book.getIsbn()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(book.getTitle()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value(book.getAuthor()));
//
//
//    }
//
//}
