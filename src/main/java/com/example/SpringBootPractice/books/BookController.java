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
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        // comprobar que no existe el ISBN + crear bad request


        Optional<Book> existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook.isPresent()) {
            return new ResponseEntity<>("Book ISBN already exists",HttpStatus.BAD_REQUEST);
        }
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBookByIsbn(@PathVariable String isbn) {
        // si no existe, retornar un 404
        // si se ha borrado, retornar ok
        Optional<Book> bookToDelete = bookRepository.findByIsbn(isbn);
        if (bookToDelete.isEmpty()) {
            return new ResponseEntity<>("Book not found with ISBN: " + isbn, HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteByIsbn(isbn);
        return new ResponseEntity<>("Book with ISBN: " + isbn + " has been deleted.", HttpStatus.OK);

    }

    // Update, modificar un libro por su ISBN

}
