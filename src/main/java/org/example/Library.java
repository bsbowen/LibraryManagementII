package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    // List to store books and users in the library
    private List<Book> books;
    private List<User> users;

    // Constructor to initialize the Library object
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library by title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Method to find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Method to find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Method to find the book with the most pages
    public Optional<Book> findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages));
    }

    // Method to find all books with more than n pages
    public List<Book> findBooksMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    // Method to print all book titles in the library, sorted alphabetically
    public void printAllBookTitles() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    // Method to find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Method to loan out a book to a user
    public void loanBook(String title, User user) {
        Optional<Book> bookToLoan = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())
                .findFirst();
        if (bookToLoan.isPresent()) {
            Book book = bookToLoan.get();
            book.setOnLoan(true);
            book.setLoanDate(LocalDate.now());
            user.addBookOnLoan(book);
        } else {
            System.out.println("Book is not available for loan.");
        }
    }

    // Method to return a book to the library
    public void returnBook(String title, User user) {
        Optional<Book> bookToReturn = user.getBooksOnLoan().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (bookToReturn.isPresent()) {
            Book book = bookToReturn.get();
            book.setOnLoan(false);
            long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
            if (daysOnLoan > 14) {
                user.accrueLateFees((daysOnLoan - 14) * 0.50); // Assuming $0.50 per day late fee
            }
            user.removeBookOnLoan(book);
            book.setLoanDate(null);
        } else {
            System.out.println("Book not found in user's loaned books.");
        }
    }

    // Method to register a user with the library
    public void registerUser(User user) {
        users.add(user);
    }

    // Method to get a list of all users in the library
    public List<User> getUsers() {
        return users;
    }
}