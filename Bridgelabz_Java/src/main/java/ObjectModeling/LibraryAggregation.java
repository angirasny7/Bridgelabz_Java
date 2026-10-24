
/*
 * Problem 1: Library and Books (Aggregation)
 * Create a Library class containing an ArrayList of Book objects.
 * Create a Book class with title and author attributes.
 * Demonstrate aggregation by creating books independently and
 * adding the same books to different libraries.
 */

package ObjectModeling;

import java.util.ArrayList;

// Class to represent a Book
class Book {

    // Attributes to store book details
    String title;
    String author;

    // Constructor to initialize book details
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Class to represent a Library
class Library {

    // ArrayList to store references to Book objects
    String libraryName;
    ArrayList<Book> books;

    // Constructor to initialize the library
    Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    void addBook(Book book) {
        books.add(book);
        System.out.println(book.title + " added to " + libraryName);
    }

    // Method to display all books in the library
    void displayBooks() {
        System.out.println("\nBooks in " + libraryName + ":");

        for (Book book : books) {
            book.displayDetails();
            System.out.println();
        }
    }
}

// Main class
public class LibraryAggregation {

    public static void main(String[] args) {

        // Create Book objects independently of any library
        Book book1 = new Book("Wings of Fire", "A. P. J. Abdul Kalam");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");
        Book book3 = new Book("Atomic Habits", "James Clear");

        // Create Library objects
        Library library1 = new Library("Central Library");
        Library library2 = new Library("City Library");

        // Add books to the first library
        library1.addBook(book1);
        library1.addBook(book2);

        // Add books to the second library
        library2.addBook(book2);
        library2.addBook(book3);

        // Display books in both libraries
        library1.displayBooks();
        library2.displayBooks();

        // Demonstrate that a book exists independently of a library
        System.out.println("Book existing independently:");
        book1.displayDetails();
    }
}
