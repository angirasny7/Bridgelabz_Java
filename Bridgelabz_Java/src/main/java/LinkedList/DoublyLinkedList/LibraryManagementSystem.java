package LinkedList.DoublyLinkedList;

/*
 * Problem Statement: Library Management System Using Doubly Linked List
 *
 * Design a library management system using a doubly linked list.
 * Each node represents a book and stores:
 * Book Title, Author, Genre, Book ID, and Availability Status.
 *
 * Implement the following operations:
 * 1. Add a book at the beginning of the list.
 * 2. Add a book at the end of the list.
 * 3. Add a book at a specific position.
 * 4. Remove a book using its Book ID.
 * 5. Search for a book by Book Title.
 * 6. Search for books by Author.
 * 7. Update a book's Availability Status.
 * 8. Display all books in forward order.
 * 9. Display all books in reverse order.
 * 10. Count the total number of books.
 *
 * Requirements:
 * - Each node must contain next and prev references.
 * - Maintain both head and tail references.
 * - The prev reference of the first node must be null.
 * - The next reference of the last node must be null.
 * - Handle empty lists and invalid positions.
 * - Do not allow duplicate Book IDs.
 */

import java.util.Scanner;

// Represents a single book node in the doubly linked list
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    Book prev;
    Book next;

    // Initializes book details and node references
    Book(String title, String author, String genre,
         int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.prev = null;
        this.next = null;
    }
}

// Manages books using a doubly linked list
class LibraryDoublyLinkedList {

    // References to the first and last books
    private Book head;
    private Book tail;

    // Keeps track of the total number of books
    private int size;

    // Searches for a book using its ID
    private Book findById(int bookId) {
        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Adds a book at the beginning
    public void insertAtBeginning(
            String title, String author, String genre,
            int bookId, boolean available) {

        // Prevent duplicate book IDs
        if (findById(bookId) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        Book newBook =
                new Book(title, author, genre, bookId, available);

        // If the list is empty, the new book becomes head and tail
        if (head == null) {
            head = tail = newBook;
        } else {
            // Connect the new book before the current head
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }

        size++;
        System.out.println("Book added at the beginning.");
    }

    // Adds a book at the end
    public void insertAtEnd(
            String title, String author, String genre,
            int bookId, boolean available) {

        if (findById(bookId) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        Book newBook =
                new Book(title, author, genre, bookId, available);

        // Handle an empty list
        if (tail == null) {
            head = tail = newBook;
        } else {
            // Connect the new book after the current tail
            newBook.prev = tail;
            tail.next = newBook;
            tail = newBook;
        }

        size++;
        System.out.println("Book added at the end.");
    }

    // Inserts a book at a specific 1-based position
    public void insertAtPosition(
            String title, String author, String genre,
            int bookId, boolean available, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (findById(bookId) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        // Position 1 means insertion at the beginning
        if (position == 1) {
            insertAtBeginning(
                    title, author, genre, bookId, available);
            return;
        }

        // Position size + 1 means insertion at the end
        if (position == size + 1) {
            insertAtEnd(
                    title, author, genre, bookId, available);
            return;
        }

        Book current = head;

        // Move to the node immediately before the target position
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Book newBook =
                new Book(title, author, genre, bookId, available);

        // Update both forward and backward links
        newBook.next = current.next;
        newBook.prev = current;

        current.next.prev = newBook;
        current.next = newBook;

        size++;
        System.out.println("Book added at position " + position);
    }

    // Removes a book using its ID
    public void removeBook(int bookId) {

        Book target = findById(bookId);

        if (target == null) {
            System.out.println("Book not found.");
            return;
        }

        // Update head if the first book is removed
        if (target == head) {
            head = target.next;
        } else {
            target.prev.next = target.next;
        }

        // Update tail if the last book is removed
        if (target == tail) {
            tail = target.prev;
        } else {
            target.next.prev = target.prev;
        }

        // Disconnect the removed node
        target.prev = null;
        target.next = null;

        size--;
        System.out.println("Book removed successfully.");
    }

    // Searches for books by title
    public void searchByTitle(String title) {

        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                displayBook(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No book found with this title.");
        }
    }

    // Searches for all books written by an author
    public void searchByAuthor(String author) {

        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                displayBook(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    // Updates a book's availability status using its ID
    public void updateAvailability(int bookId, boolean available) {

        Book book = findById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        book.available = available;

        System.out.println("Book availability updated successfully.");
    }

    // Displays the details of a single book
    private void displayBook(Book book) {
        System.out.println("Book ID    : " + book.bookId);
        System.out.println("Title      : " + book.title);
        System.out.println("Author     : " + book.author);
        System.out.println("Genre      : " + book.genre);
        System.out.println("Availability: "
                + (book.available ? "Available" : "Not Available"));
        System.out.println("--------------------------------");
    }

    // Displays all books from head to tail
    public void displayForward() {

        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;

        System.out.println("\n--- Books in Forward Order ---");

        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // Displays all books from tail to head
    public void displayReverse() {

        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = tail;

        System.out.println("\n--- Books in Reverse Order ---");

        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // Returns the total number of books
    public int countBooks() {
        return size;
    }
}

// Main class for the library management application
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDoublyLinkedList library =
                new LibraryDoublyLinkedList();

        int choice;

        // Display the menu until the user chooses to exit
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add book at beginning");
            System.out.println("2. Add book at end");
            System.out.println("3. Add book at specific position");
            System.out.println("4. Remove book by ID");
            System.out.println("5. Search book by title");
            System.out.println("6. Search books by author");
            System.out.println("7. Update book availability");
            System.out.println("8. Display books forward");
            System.out.println("9. Display books in reverse");
            System.out.println("10. Count total books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            String title;
            String author;
            String genre;
            int bookId;
            int position;
            boolean available;

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    // Read the details of the new book
                    System.out.print("Enter book title: ");
                    title = sc.nextLine();

                    System.out.print("Enter author: ");
                    author = sc.nextLine();

                    System.out.print("Enter genre: ");
                    genre = sc.nextLine();

                    System.out.print("Enter book ID: ");
                    bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Is the book available? (yes/no): ");
                    available = sc.nextLine().equalsIgnoreCase("yes");

                    // Perform the selected insertion operation
                    if (choice == 1) {
                        library.insertAtBeginning(
                                title, author, genre, bookId, available);
                    } else if (choice == 2) {
                        library.insertAtEnd(
                                title, author, genre, bookId, available);
                    } else {
                        System.out.print(
                                "Enter position (starting from 1): ");
                        position = sc.nextInt();
                        sc.nextLine();

                        library.insertAtPosition(
                                title, author, genre, bookId,
                                available, position);
                    }
                    break;

                case 4:
                    // Remove a book using its ID
                    System.out.print("Enter book ID to remove: ");
                    bookId = sc.nextInt();

                    library.removeBook(bookId);
                    break;

                case 5:
                    // Search by book title
                    System.out.print("Enter book title: ");
                    title = sc.nextLine();

                    library.searchByTitle(title);
                    break;

                case 6:
                    // Search by author
                    System.out.print("Enter author name: ");
                    author = sc.nextLine();

                    library.searchByAuthor(author);
                    break;

                case 7:
                    // Update the availability of a book
                    System.out.print("Enter book ID: ");
                    bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print(
                            "Set availability (yes/no): ");
                    available =
                            sc.nextLine().equalsIgnoreCase("yes");

                    library.updateAvailability(bookId, available);
                    break;

                case 8:
                    // Display all books from first to last
                    library.displayForward();
                    break;

                case 9:
                    // Display all books from last to first
                    library.displayReverse();
                    break;

                case 10:
                    // Display the total number of books
                    System.out.println(
                            "Total number of books: "
                                    + library.countBooks());
                    break;

                case 0:
                    System.out.println(
                            "Exiting Library Management System.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
