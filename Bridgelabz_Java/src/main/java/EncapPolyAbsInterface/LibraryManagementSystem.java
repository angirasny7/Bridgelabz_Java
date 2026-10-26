package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 5: Library Management System
 *
 * Develop a library system with an abstract LibraryItem class,
 * Book, Magazine, and DVD subclasses, and a Reservable interface.
 *
 * Use encapsulation to protect item details, abstraction to define
 * loan durations, and polymorphism to process different library items.
 */

// Interface defining reservation-related behavior
interface Reservable {

    // Reserve an available library item
    boolean reserveItem(String borrowerName);

    // Check whether the item is available
    boolean checkAvailability();
}

// Abstract class representing a general library item
abstract class LibraryItem {

    private final int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        if (itemId <= 0) {
            throw new IllegalArgumentException(
                    "Item ID must be positive."
            );
        }

        this.itemId = itemId;
        setTitle(title);
        setAuthor(author);
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty."
            );
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Author cannot be empty."
            );
        }
        this.author = author;
    }

    // Each library item defines its own loan duration
    public abstract int getLoanDuration();

    // Display common item information
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: "
                + getLoanDuration() + " days");
    }
}

// Book implementation
class Book extends LibraryItem implements Reservable {

    private boolean available;
    private String borrowerName;

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
        this.available = true;
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!checkAvailability()) {
            System.out.println("Book is not available.");
            return false;
        }

        if (borrowerName == null ||
                borrowerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Borrower name cannot be empty."
            );
        }

        this.borrowerName = borrowerName;
        this.available = false;

        System.out.println("Book reserved successfully.");
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    // Return the item and clear borrower information
    public void returnItem() {
        if (available) {
            System.out.println("Book is already available.");
            return;
        }

        available = true;
        borrowerName = null;
        System.out.println("Book returned successfully.");
    }
}

// Magazine implementation
class Magazine extends LibraryItem implements Reservable {

    private boolean available;
    private String borrowerName;

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
        this.available = true;
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!checkAvailability()) {
            System.out.println("Magazine is not available.");
            return false;
        }

        if (borrowerName == null ||
                borrowerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Borrower name cannot be empty."
            );
        }

        this.borrowerName = borrowerName;
        this.available = false;

        System.out.println("Magazine reserved successfully.");
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    public void returnItem() {
        if (available) {
            System.out.println("Magazine is already available.");
            return;
        }

        available = true;
        borrowerName = null;
        System.out.println("Magazine returned successfully.");
    }
}

// DVD implementation
class DVD extends LibraryItem implements Reservable {

    private boolean available;
    private String borrowerName;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
        this.available = true;
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (!checkAvailability()) {
            System.out.println("DVD is not available.");
            return false;
        }

        if (borrowerName == null ||
                borrowerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Borrower name cannot be empty."
            );
        }

        this.borrowerName = borrowerName;
        this.available = false;

        System.out.println("DVD reserved successfully.");
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    public void returnItem() {
        if (available) {
            System.out.println("DVD is already available.");
            return;
        }

        available = true;
        borrowerName = null;
        System.out.println("DVD returned successfully.");
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create different library items
        Book book = new Book(
                101, "Java Programming", "James Gosling"
        );

        Magazine magazine = new Magazine(
                102, "Science Today", "Science Editorial Team"
        );

        DVD dvd = new DVD(
                103, "Java Tutorials", "Learning Media"
        );

        // Store all items using the parent class reference
        List<LibraryItem> items = new ArrayList<>();

        items.add(book);
        items.add(magazine);
        items.add(dvd);

        // Polymorphism: each item provides its own loan duration
        for (LibraryItem item : items) {
            System.out.println("\n----------------------");
            item.getItemDetails();

            // All three subclasses implement Reservable
            Reservable reservable = (Reservable) item;

            System.out.println(
                    "Available: " + reservable.checkAvailability()
            );
        }

        // Demonstrate reservation and return
        System.out.println("\n--- Reservation Process ---");

        book.reserveItem("Rahul");
        System.out.println(
                "Book available: " + book.checkAvailability()
        );

        book.returnItem();
        System.out.println(
                "Book available: " + book.checkAvailability()
        );
    }
}

