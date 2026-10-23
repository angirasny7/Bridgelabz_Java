
/*
 * Problem 2: Book Library System
 * Create a Book class with public ISBN, protected title,
 * and private author.
 * Write methods to set and get the author name.
 * Create an EBook subclass to access ISBN and title and
 * demonstrate access modifiers.
 */

package Constructor.Level3;

// Parent class
class Book {

    // Public member: accessible from anywhere
    public String ISBN;

    // Protected member: accessible within the package and subclasses
    protected String title;

    // Private member: accessible only within the Book class
    private String author;

    // Constructor to initialize book details
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter method to modify the private author attribute
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method to access the private author attribute
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass extending Book
class EBook extends Book {

    // Additional attribute for an electronic book
    double fileSize;

    // Constructor to initialize EBook details
    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    // Method to demonstrate access to public and protected members
    void displayEBookDetails() {

        // Public member accessed directly
        System.out.println("ISBN: " + ISBN);

        // Protected member accessed directly in the subclass
        System.out.println("Title: " + title);

        // Private member accessed through the public getter
        System.out.println("Author: " + getAuthor());

        System.out.println("File Size: " + fileSize + " MB");
    }
}

// Main class
public class BookLibrarySystem {

    public static void main(String[] args) {

        // Create an EBook object
        EBook ebook = new EBook(
                "978-0135166307",
                "Effective Java",
                "Joshua Bloch",
                5.5
        );

        // Display initial EBook details
        System.out.println("EBook Details:");
        ebook.displayEBookDetails();

        // Modify the private author attribute using the setter
        ebook.setAuthor("Joshua Bloch (Updated)");

        // Display the updated author using the getter
        System.out.println("\nUpdated Author: " + ebook.getAuthor());
    }
}
