package Strings.Level1;

import java.util.Scanner;

/*
 * Question:
 * Write a program to demonstrate IllegalArgumentException.
 * Take a string as user input and use substring() with the start
 * index greater than the end index to generate a runtime exception.
 * Handle the exception using try-catch blocks.
 */

public class IllegalArgumentDemo {

    // Method to generate the exception without handling it
    public static void generateException(String text) {
        // Start index is greater than the end index
        System.out.println(text.substring(4, 2));
    }

    // Method to demonstrate exception handling
    public static void handleException(String text) {
        try {
            // This statement generates an index-related exception
            System.out.println(text.substring(4, 2));

        } catch (StringIndexOutOfBoundsException e) {
            // Handles an invalid substring index range
            System.out.println("StringIndexOutOfBoundsException handled!");
            System.out.println("Error: Start index cannot be greater than end index.");

        } catch (RuntimeException e) {
            // Handles other runtime exceptions
            System.out.println("RuntimeException handled: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with at least 5 characters: ");
        String text = sc.next();

        System.out.println("\nCalling method to generate the exception:");

        try {
            // Catch the exception so the program can continue
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nCalling method to handle the exception:");

        // The exception is handled inside this method
        handleException(text);

        System.out.println("Program continues normally.");

        sc.close();
    }
}