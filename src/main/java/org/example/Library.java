package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// The Library class represents a collection of books and users, and provides methods to manage them
public class Library {
    // Attributes of the Library class
    private List<Book> books;   // List to store books in the library
    private List<User> users;   // List to store users registered with the library

    // Constructor to initialize a Library object with empty lists of books and users
    public Library() {
        this.books = new ArrayList<>();   // Initializing the list of books as an empty ArrayList
        this.users = new ArrayList<>();   // Initializing the list of users as an empty ArrayList
    }

    // Method to add a book to the library's collection
    public void addBook(Book book) {
        books.add(book);   // Adds the given book to the books list
    }

    // Method to remove a book from the library by its title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));   // Removes the book with the matching title
    }

    // Method to find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()   // Streams the books list
                .filter(book -> book.getPublicationYear() == year)   // Filters books by publication year
                .collect(Collectors.toList());   // Collects the result as a List of books
    }

    // Method to find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()   // Streams the books list
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))   // Filters books by author
                .collect(Collectors.toList());   // Collects the result as a List of books
    }

    // Method to find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream()   // Streams the books list
                .max(Comparator.comparingInt(Book::getPages));   // Finds the book with the maximum page count
    }

    // Method to find all books with more than n pages
    public List<Book> findBooksMoreThanNPages(int n) {
        return books.stream()   // Streams the books list
                .filter(book -> book.getPages() > n)   // Filters books with pages greater than n
                .collect(Collectors.toList());   // Collects the result as a List of books
    }

    // Method to print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream()   // Streams the books list
                .map(Book::getTitle)   // Maps each book to its title
                .sorted()   // Sorts the titles alphabetically
                .forEach(System.out::println);   // Prints each title to the console
    }

    // Method to find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()   // Streams the books list
                .filter(book -> book.getCategory().equalsIgnoreCase(category))   // Filters books by category
                .collect(Collectors.toList());   // Collects the result as a List of books
    }

    // Method to loan out a book to a user
    public void loanBook(String title, User user) {
        Optional<Book> bookToLoan = books.stream()   // Streams the books list
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())   // Filters for the book by title and checks if it's not on loan
                .findFirst();   // Retrieves the first matching book, if any
        if (bookToLoan.isPresent()) {   // If a book is found
            Book book = bookToLoan.get();   // Get the book object
            book.setOnLoan(true);   // Mark the book as on loan
            book.setLoanDate(LocalDate.now());   // Set the loan date to today's date
            user.addBookOnLoan(book);   // Add the book to the user's list of loaned books
        } else {
            System.out.println("Book is not available for loan.");   // Print message if the book is not available
        }
    }

    // Method to return a book to the library
    public void returnBook(String title, User user) {
        Optional<Book> bookToReturn = user.getBooksOnLoan().stream()   // Streams the user's loaned books
                .filter(book -> book.getTitle().equalsIgnoreCase(title))   // Filters for the book by title
                .findFirst();   // Retrieves the first matching book, if any
        if (bookToReturn.isPresent()) {   // If a book is found
            Book book = bookToReturn.get();   // Get the book object
            book.setOnLoan(false);   // Mark the book as not on loan
            long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());   // Calculate the number of days the book was on loan
            if (daysOnLoan > 14) {   // If the book was on loan for more than 14 days
                user.accrueLateFees((daysOnLoan - 14) * 0.50);   // Accrue late fees at $0.50 per day
            }
            user.removeBookOnLoan(book);   // Remove the book from the user's list of loaned books
            book.setLoanDate(null);   // Clear the loan date of the book
        } else {
            System.out.println("Book not found in user's loaned books.");   // Print message if the book is not found in the user's loaned books
        }
    }

    // Method to register a user with the library
    public void registerUser(User user) {
        users.add(user);   // Adds the user to the users list
    }

    // Method to get a list of all users registered with the library
    public List<User> getUsers() {
        return users;   // Returns the list of users
    }
}

/*
The `Library` class manages a collection of books and users in a library system. It provides methods
to add and remove books, find books by various criteria (e.g., year, author, category, number of pages),
and loan and return books to users. The class also handles the registration of users and tracks loaned
books and late fees. Stream operations are extensively used for filtering and processing collections of
books, while `Optional` is utilized to handle the possibility of operations returning null values. The
class ensures that books are managed properly within the library, including marking books as on loan or
returned and calculating late fees for overdue books.
*/