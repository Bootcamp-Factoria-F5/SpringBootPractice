package com.example.SpringBootPractice.books;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {
    List<Book> findAll();

     default Optional<Book> findByIsbn(String isbn) {
        return Optional.empty();
    }

    void save(Book book);
}
