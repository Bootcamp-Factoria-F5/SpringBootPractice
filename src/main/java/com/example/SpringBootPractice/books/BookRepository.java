package com.example.SpringBootPractice.books;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findAll();

    default Book findByIsbn(String isbn) {
        return null;
    }

}
