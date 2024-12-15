package com.example.SpringBootPractice.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {

    private final static List<Book> booksDB = new ArrayList<>();

    public InMemoryBookRepository() {
        booksDB.add(new Book("A123", "titulo del libro 1", "author del libro 1"));
        booksDB.add(new Book("A124", "titulo del libro 2", "author del libro 2"));
        booksDB.add(new Book("A125", "titulo del libro 3", "author del libro 3"));
    }

    @Override
    public List<Book> findAll() {
        return Collections.unmodifiableList(booksDB);
    }

    @Override
    public Book findByIsbn(String isbn) {
        for (Book book : booksDB) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }


}
