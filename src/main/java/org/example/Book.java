package org.example;

import java.time.LocalDate;

// The Book class represents a book in the library system
public class Book {
    // Attributes of the Book class representing the book's details
    private String title;            // Title of the book
    private String author;           // Author of the book
    private int publicationYear;     // Year the book was published
    private int pages;               // Number of pages in the book
    private String category;         // Category or genre of the book
    private boolean isOnLoan;        // Flag indicating if the book is currently on loan
    private LocalDate loanDate;      // Date when the book was loaned out

    // Constructor to initialize a Book object with given attributes
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;                       // Assigning the title to the book's title attribute
        this.author = author;                     // Assigning the author to the book's author attribute
        this.publicationYear = publicationYear;   // Assigning the publication year to the book's publicationYear attribute
        this.pages = pages;                       // Assigning the number of pages to the book's pages attribute
        this.category = category;                 // Assigning the category to the book's category attribute
        this.isOnLoan = false;                    // Initially, the book is not on loan, so isOnLoan is set to false
    }

    // Getter methods to retrieve the attributes of the Book class
    public String getTitle() {
        return title;    // Returns the title of the book
    }

    public String getAuthor() {
        return author;   // Returns the author of the book
    }

    public int getPublicationYear() {
        return publicationYear;   // Returns the year the book was published
    }

    public int getPages() {
        return pages;   // Returns the number of pages in the book
    }

    public String getCategory() {
        return category;   // Returns the category or genre of the book
    }

    public boolean isOnLoan() {
        return isOnLoan;   // Returns whether the book is currently on loan
    }

    public LocalDate getLoanDate() {
        return loanDate;   // Returns the date when the book was loaned out
    }

    // Setter methods to modify the attributes of the Book class
    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;   // Sets the onLoan status of the book to true or false
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;   // Sets the loan date of the book to the specified date
    }
}


/*
The `Book` class represents a book in the library system, encapsulating its attributes such as
title, author, publication year, number of pages, category, loan status, and loan date. The class
includes a constructor to initialize these attributes when a `Book` object is created. It also
provides getter methods for external access to these private attributes and setter methods to
allow modification of the loan status and loan date. This design follows the principle of
encapsulation, where the class maintains control over its data by restricting direct access
through private fields and exposing only necessary methods to interact with the data.
*/
