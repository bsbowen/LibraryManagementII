package org.example;

import java.util.ArrayList;
import java.util.List;

// The User class represents a library user in the system
public class User {
    // Attributes of the User class representing the user's details
    private String name;                   // Name of the user
    private String libraryCardNumber;      // Library card number assigned to the user
    private List<Book> booksOnLoan;        // List of books currently loaned by the user
    private double lateFees;               // Accumulated late fees for the user

    // Constructor to initialize a User object with the given name and library card number
    public User(String name, String libraryCardNumber) {
        this.name = name;                              // Assigning the name to the user's name attribute
        this.libraryCardNumber = libraryCardNumber;    // Assigning the library card number to the user's libraryCardNumber attribute
        this.booksOnLoan = new ArrayList<>();          // Initializing the list of books on loan as an empty ArrayList
        this.lateFees = 0.0;                           // Initializing late fees to zero
    }

    // Getter methods to retrieve the attributes of the User class
    public String getName() {
        return name;    // Returns the name of the user
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;   // Returns the library card number of the user
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;   // Returns the list of books currently on loan to the user
    }

    public double getLateFees() {
        return lateFees;   // Returns the total amount of late fees accrued by the user
    }

    // Methods to manage the user's loaned books
    public void addBookOnLoan(Book book) {
        this.booksOnLoan.add(book);   // Adds a book to the user's list of loaned books
    }

    public void removeBookOnLoan(Book book) {
        this.booksOnLoan.remove(book);   // Removes a book from the user's list of loaned books
    }

    // Method to accrue late fees for the user
    public void accrueLateFees(double amount) {
        this.lateFees += amount;   // Increases the user's total late fees by the specified amount
    }
}


/*
The `User` class represents a user in the library system, encapsulating their details such as
name, library card number, list of loaned books, and accumulated late fees. The class includes
a constructor to initialize a user with a name and library card number, and it initializes an
empty list to track books on loan and sets late fees to zero. Getter methods provide access to
the user's attributes, while methods for managing loaned books allow adding and removing books
from the user's loan list. The class also includes a method to accrue late fees, updating the
total fees owed by the user.
*/