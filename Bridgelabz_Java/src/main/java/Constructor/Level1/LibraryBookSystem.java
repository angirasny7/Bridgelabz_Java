
/*
 * Question: Library Book System
 * Create a Book class with attributes title, author, price,
 * and availability. Implement a method to borrow a book.
 */

package Constructor.Level1;

import java.util.Scanner;

// Class to represent a Library Book
class BookDetails {

    // Attributes to store book details
    String title;
    String author;
    double price;
    boolean availability;

    // Parameterized constructor to initialize book details
    BookDetails(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow a book
    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry, the book is not available.");
        }
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("\n----- Book Details -----");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Availability: "
                + (availability ? "Available" : "Borrowed"));
    }
}

// Main class
public class LibraryBookSystem {

    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create a Book object
        BookDetails book = new BookDetails(
                "Wings of Fire",
                "A. P. J. Abdul Kalam",
                250.00,
                true
        );

        // Display the initial book details
        book.displayDetails();

        // Ask the user whether they want to borrow the book
        System.out.print("\nDo you want to borrow this book? (yes/no): ");
        String choice = input.nextLine();

        // Borrow the book if the user chooses yes
        if (choice.equalsIgnoreCase("yes")) {
            book.borrowBook();
        } else {
            System.out.println("Book not borrowed.");
        }

        // Display the updated book details
        book.displayDetails();

        // Close the Scanner
        input.close();
    }
}
