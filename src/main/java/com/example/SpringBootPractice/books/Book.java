package com.example.SpringBootPractice.books;

public class Book {
    private String isbn;   // Attributes, encapsulated and protected. Access provided through Getters
    private String title;  // These fields are the data that a Book object holds.
    private String author; // Other parts of your code interact with these fields indirectly through the constructor and getters.


    // A constructor ensures that a Book object is valid and initialized properly from the start
    // A method to initialize objects with valid data
    // Whenever you create a new Book object (new Book(...)), this constructor runs to assign values to the fields

    public Book(String isbn, String title, String author) {   //parameters match the fields
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Use this to distinguish between fields and parameters


    // Getters allow controlled access to private fields safely, following the principle of encapsulation
    public String getIsbn() {     // A method that retrieves the isbn field.
        return isbn;              // Returns the value of the isbn field.
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
