package LinkedList.DoublyLinkedList;

/*
 * Problem Statement: Movie Management System Using Doubly Linked List
 *
 * Create a movie management system using a doubly linked list.
 * Each node stores the following movie information:
 * Movie Title, Director, Year of Release, and Rating.
 *
 * Implement the following operations:
 * 1. Add a movie at the beginning of the list.
 * 2. Add a movie at the end of the list.
 * 3. Add a movie at a specific position.
 * 4. Remove a movie using its title.
 * 5. Search for movies by director.
 * 6. Search for movies by rating.
 * 7. Display all movies in forward order.
 * 8. Display all movies in reverse order.
 * 9. Update a movie's rating using its title.
 *
 * Requirements:
 * - Each node must contain prev and next references.
 * - Maintain both head and tail references.
 * - The prev reference of the first node must be null.
 * - The next reference of the last node must be null.
 * - Handle empty lists and invalid positions.
 */

import java.util.Scanner;

// Represents a single movie node in the doubly linked list
class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;

    Movie prev;
    Movie next;

    // Initializes movie details and node references
    Movie(String title, String director, int yearOfRelease,
          double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

// Manages movie records using a doubly linked list
class MovieDoublyLinkedList {

    // References to the first and last nodes
    private Movie head;
    private Movie tail;

    // Searches for a movie by its title
    private Movie findByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    // Adds a movie at the beginning
    public void insertAtBeginning(String title, String director,
                                  int year, double rating) {

        // Avoid duplicate movie titles
        if (findByTitle(title) != null) {
            System.out.println("Movie title already exists.");
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        // If the list is empty, the new movie is both head and tail
        if (head == null) {
            head = tail = newMovie;
        } else {
            // Connect the new node to the current first node
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }

        System.out.println("Movie added at the beginning.");
    }

    // Adds a movie at the end
    public void insertAtEnd(String title, String director,
                            int year, double rating) {

        if (findByTitle(title) != null) {
            System.out.println("Movie title already exists.");
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        // Handle an empty list
        if (tail == null) {
            head = tail = newMovie;
        } else {
            // Connect the new node to the current last node
            newMovie.prev = tail;
            tail.next = newMovie;
            tail = newMovie;
        }

        System.out.println("Movie added at the end.");
    }

    // Inserts a movie at a specified 1-based position
    public void insertAtPosition(String title, String director,
                                 int year, double rating,
                                 int position) {

        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (findByTitle(title) != null) {
            System.out.println("Movie title already exists.");
            return;
        }

        // Position 1 means insertion at the beginning
        if (position == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        Movie current = head;

        // Move to the node immediately before the target position
        for (int i = 1;
             i < position - 1 && current != null;
             i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // If current is the last node, insert at the end
        if (current == tail) {
            insertAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        // Update both forward and backward links
        newMovie.next = current.next;
        newMovie.prev = current;

        current.next.prev = newMovie;
        current.next = newMovie;

        System.out.println("Movie added at position " + position);
    }

    // Removes a movie using its title
    public void removeMovie(String title) {

        Movie target = findByTitle(title);

        if (target == null) {
            System.out.println("Movie not found.");
            return;
        }

        // Update head if the first node is removed
        if (target == head) {
            head = target.next;
        } else {
            target.prev.next = target.next;
        }

        // Update tail if the last node is removed
        if (target == tail) {
            tail = target.prev;
        } else {
            target.next.prev = target.prev;
        }

        // Disconnect the removed node
        target.prev = null;
        target.next = null;

        System.out.println("Movie removed successfully.");
    }

    // Searches for and displays movies by director
    public void searchByDirector(String director) {

        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovie(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for this director.");
        }
    }

    // Searches for movies with an exact rating
    public void searchByRating(double rating) {

        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (Double.compare(current.rating, rating) == 0) {
                displayMovie(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with this rating.");
        }
    }

    // Displays a single movie's details
    private void displayMovie(Movie movie) {
        System.out.println("Title          : " + movie.title);
        System.out.println("Director       : " + movie.director);
        System.out.println("Year of Release: " + movie.yearOfRelease);
        System.out.println("Rating         : " + movie.rating);
        System.out.println("--------------------------------");
    }

    // Displays all movies from head to tail
    public void displayForward() {

        if (head == null) {
            System.out.println("No movie records available.");
            return;
        }

        Movie current = head;

        System.out.println("\n--- Movies in Forward Order ---");

        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }

    // Displays all movies from tail to head
    public void displayReverse() {

        if (tail == null) {
            System.out.println("No movie records available.");
            return;
        }

        Movie current = tail;

        System.out.println("\n--- Movies in Reverse Order ---");

        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }

    // Updates a movie's rating using its title
    public void updateRating(String title, double newRating) {

        Movie movie = findByTitle(title);

        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        // Validate the new rating
        if (newRating < 0 || newRating > 10) {
            System.out.println("Rating must be between 0 and 10.");
            return;
        }

        movie.rating = newRating;
        System.out.println("Movie rating updated successfully.");
    }
}

// Main class for the menu-driven movie management system
public class MovieManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        int choice;

        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add movie at beginning");
            System.out.println("2. Add movie at end");
            System.out.println("3. Add movie at specific position");
            System.out.println("4. Remove movie by title");
            System.out.println("5. Search movies by director");
            System.out.println("6. Search movies by rating");
            System.out.println("7. Display movies forward");
            System.out.println("8. Display movies in reverse");
            System.out.println("9. Update movie rating");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline

            String title;
            String director;
            int year;
            int position;
            double rating;

            switch (choice) {

                case 1:
                    // Read movie details and insert at the beginning
                    System.out.print("Enter movie title: ");
                    title = sc.nextLine();

                    System.out.print("Enter director: ");
                    director = sc.nextLine();

                    System.out.print("Enter year of release: ");
                    year = sc.nextInt();

                    System.out.print("Enter rating (0-10): ");
                    rating = sc.nextDouble();
                    sc.nextLine();

                    if (rating < 0 || rating > 10) {
                        System.out.println("Rating must be between 0 and 10.");
                        break;
                    }

                    list.insertAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    // Read movie details and insert at the end
                    System.out.print("Enter movie title: ");
                    title = sc.nextLine();

                    System.out.print("Enter director: ");
                    director = sc.nextLine();

                    System.out.print("Enter year of release: ");
                    year = sc.nextInt();

                    System.out.print("Enter rating (0-10): ");
                    rating = sc.nextDouble();
                    sc.nextLine();

                    if (rating < 0 || rating > 10) {
                        System.out.println("Rating must be between 0 and 10.");
                        break;
                    }

                    list.insertAtEnd(title, director, year, rating);
                    break;

                case 3:
                    // Read movie details and target position
                    System.out.print("Enter movie title: ");
                    title = sc.nextLine();

                    System.out.print("Enter director: ");
                    director = sc.nextLine();

                    System.out.print("Enter year of release: ");
                    year = sc.nextInt();

                    System.out.print("Enter rating (0-10): ");
                    rating = sc.nextDouble();

                    System.out.print("Enter position (starting from 1): ");
                    position = sc.nextInt();
                    sc.nextLine();

                    if (rating < 0 || rating > 10) {
                        System.out.println("Rating must be between 0 and 10.");
                        break;
                    }

                    list.insertAtPosition(
                            title, director, year, rating, position);
                    break;

                case 4:
                    // Remove a movie by title
                    System.out.print("Enter movie title to remove: ");
                    title = sc.nextLine();

                    list.removeMovie(title);
                    break;

                case 5:
                    // Search for all movies by a director
                    System.out.print("Enter director name: ");
                    director = sc.nextLine();

                    list.searchByDirector(director);
                    break;

                case 6:
                    // Search for movies by exact rating
                    System.out.print("Enter rating to search: ");
                    rating = sc.nextDouble();
                    sc.nextLine();

                    list.searchByRating(rating);
                    break;

                case 7:
                    // Display the list from head to tail
                    list.displayForward();
                    break;

                case 8:
                    // Display the list from tail to head
                    list.displayReverse();
                    break;

                case 9:
                    // Update a movie's rating
                    System.out.print("Enter movie title: ");
                    title = sc.nextLine();

                    System.out.print("Enter new rating (0-10): ");
                    rating = sc.nextDouble();
                    sc.nextLine();

                    list.updateRating(title, rating);
                    break;

                case 0:
                    System.out.println("Exiting Movie Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
