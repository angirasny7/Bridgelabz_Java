
/*
 * Question: Create a Book class with attributes title, author, and price.
 * Provide both default and parameterized constructors.
 */

package Constructor.Level1;

// Class to represent a Book
class Book {

    // Attributes to store book details
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: %.2f%n", price);
        System.out.println();
    }
}

// Main class
public class BookDemo {

    public static void main(String[] args) {

        // Create an object using the default constructor
        Book book1 = new Book();

        // Create an object using the parameterized constructor
        Book book2 = new Book("Wings of Fire", "A. P. J. Abdul Kalam", 250.0);

        // Display details of both books
        System.out.println("Book 1 (Default Constructor):");
        book1.displayDetails();

        System.out.println("Book 2 (Parameterized Constructor):");
        book2.displayDetails();
    }
}
