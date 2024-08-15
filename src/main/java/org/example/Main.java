package org.example;

// Importing necessary classes from the java.util package
import java.util.List;
import java.util.Optional;

// Main class of the program
public class Main {
    // Entry point of the program; the main method is where the program begins execution
    public static void main(String[] args) {
        // Creating an instance of the Library class
        Library library = new Library();

        // Adding books to the library using the addBook method of the Library class
        // Each new Book object is created with its title, author, year of publication, page count, and category
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 218, "Fiction"));
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Science Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("The Art of War", "Sun Tzu", -500, 273, "History"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction"));

        // Creating a new User object with a name and ID and registering the user with the library
        User user1 = new User("John Doe", "12345");
        library.registerUser(user1);

        // Attempting to loan a book to the user by its title
        // The loanBook method checks if the book is available and, if so, assigns it to the user
        library.loanBook("1984", user1);
        // Attempting to loan the same book again, which should fail since it's already loaned out
        library.loanBook("1984", user1);

        // Returning the book by the user
        // The returnBook method updates the book's status and checks for late fees
        library.returnBook("1984", user1);

        // Testing late fees functionality
        // Loaning the book again to the same user
        library.loanBook("1984", user1);
        // Simulating a late return by manually adjusting the loan date to be 15 days earlier
        user1.getBooksOnLoan().get(0).setLoanDate(user1.getBooksOnLoan().get(0).getLoanDate().minusDays(15));
        // Returning the book, which should now incur a late fee
        library.returnBook("1984", user1);
        // Displaying the total late fees incurred by the user
        System.out.println("User late fees: $" + user1.getLateFees());

        // Finding all books in the "Fiction" category using the findBooksByCategory method
        List<Book> fictionBooks = library.findBooksByCategory("Fiction");
        // Printing the number of fiction books found
        System.out.println("Fiction Books: " + fictionBooks.size());

        // Finding the book with the most pages using the findBookWithMostPages method
        // The method returns an Optional<Book> which may or may not contain a result
        Optional<Book> bookWithMostPages = library.findBookWithMostPages();
        // If the book with the most pages is present, print its title
        bookWithMostPages.ifPresent(book -> System.out.println("Book with most pages: " + book.getTitle()));

        // Printing all book titles sorted alphabetically
        System.out.println("All Book Titles:");
        library.printAllBookTitles();
    }
}

/*
This program simulates a basic library management system, implemented in Java. It includes three
main classes: `Library`, `Book`, and `User`. The `Library` class manages a collection of books
and registered users, allowing for operations such as adding books, registering users, loaning
and returning books, calculating late fees, and searching for books by various criteria. The
`Book` class represents individual books with attributes like title, author, publication year,
page count, and category. The `User` class tracks users who can borrow books, along with their
loan history and any accrued late fees. The `Main` class contains the `main` method, which
demonstrates the functionality of these classes by simulating the addition of books, registration
of a user, loaning and returning books, calculating late fees, and searching for books. The
program showcases object-oriented principles such as encapsulation, inheritance, and method
invocation, making it a useful example of basic library management in Java.
*/