package com.example.SpringBootPractice.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController() {
        this.bookRepository = new InMemoryBookRepository();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }


}
