package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 218, "Fiction"));
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Science Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("The Art of War", "Sun Tzu", -500, 273, "History"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction"));

        // Registering users
        User user1 = new User("John Doe", "12345");
        library.registerUser(user1);

        // Testing book loan
        library.loanBook("1984", user1);
        library.loanBook("1984", user1); // Attempt to loan the same book again

        // Testing book return
        library.returnBook("1984", user1);

        // Testing late fees
        library.loanBook("1984", user1);
        // Simulating late return
        user1.getBooksOnLoan().get(0).setLoanDate(user1.getBooksOnLoan().get(0).getLoanDate().minusDays(15));
        library.returnBook("1984", user1);
        System.out.println("User late fees: $" + user1.getLateFees());

        // Finding books
        List<Book> fictionBooks = library.findBooksByCategory("Fiction");
        System.out.println("Fiction Books: " + fictionBooks.size());

        // Finding book with most pages
        Optional<Book> bookWithMostPages = library.findBookWithMostPages();
        bookWithMostPages.ifPresent(book -> System.out.println("Book with most pages: " + book.getTitle()));

        // Print all book titles sorted alphabetically
        System.out.println("All Book Titles:");
        library.printAllBookTitles();
    }
}