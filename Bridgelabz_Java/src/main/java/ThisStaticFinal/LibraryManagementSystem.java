
/*
 * Sample Program 2: Library Management System
 * 1. Use a static variable libraryName shared by all books.
 * 2. Use a static method displayLibraryName() to print the library name.
 * 3. Use this to initialize title, author, and isbn in the constructor.
 * 4. Use a final variable isbn that cannot be reassigned.
 * 5. Use instanceof to verify the object type before displaying details.
 */

package ThisStaticFinal;

// Class to represent a Book
class Book {

    // Static variable shared by all Book objects
    static String libraryName = "Central Public Library";

    // Instance variables
    String title;
    String author;

    // Final variable: ISBN cannot be reassigned after initialization
    final String isbn;

    // Constructor to initialize book details
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display the library name
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create Book objects
        Book book1 = new Book(
                "Wings of Fire",
                "A. P. J. Abdul Kalam",
                "978-8173711466"
        );

        Book book2 = new Book(
                "The Alchemist",
                "Paulo Coelho",
                "978-0061122415"
        );

        // Call the static method using the class name
        Book.displayLibraryName();

        // Store a Book object in an Object reference
        Object obj = book1;

        // Verify the object type using instanceof
        if (obj instanceof Book) {
            System.out.println("\n----- Book 1 Details -----");

            // Typecast Object to Book
            Book book = (Book) obj;
            book.displayDetails();
        } else {
            System.out.println("Object is not a Book.");
        }

        // Display the second book's details
        System.out.println("\n----- Book 2 Details -----");
        book2.displayDetails();
    }
}
