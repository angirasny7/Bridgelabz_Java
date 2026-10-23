package ClassesAndObjects.Level1;
import java.util.Scanner;

/*
 * Question: Handle Book Details
 * Create a Book class with attributes title, author, and price.
 * Add a method to display the book details.
 */

// Class to represent a Book
class Book{
    // Attributes to store book details
    String title;
    String author;
    double price;

    // Method to display book details
    void display(){
        System.out.println("Book Details: ");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class DisplayBookDetails {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Create an object of the Book class
        Book book = new Book();

        System.out.print("Enter the book title: ");
        book.title = input.nextLine();

        System.out.print("Enter the author name: ");
        book.author = input.nextLine();

        System.out.print("Enter the price: ");
        book.price = input.nextDouble();

        book.display();

        input.close();

    }
}
