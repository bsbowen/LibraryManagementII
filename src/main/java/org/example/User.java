package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    // Attributes of the User class
    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan;
    private double lateFees;

    // Constructor to initialize the User object
    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
        this.lateFees = 0.0;
    }

    // Getter methods to access the attributes of the User class
    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public double getLateFees() {
        return lateFees;
    }

    // Methods to add and remove books from the user's loan list
    public void addBookOnLoan(Book book) {
        this.booksOnLoan.add(book);
    }

    public void removeBookOnLoan(Book book) {
        this.booksOnLoan.remove(book);
    }

    // Method to accrue late fees
    public void accrueLateFees(double amount) {
        this.lateFees += amount;
    }
}
