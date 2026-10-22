package Strings.Level1;

import java.util.Scanner;

/*
 * Question:
 * Write a program to demonstrate ArrayIndexOutOfBoundsException.
 * Take an array of names as user input and access an index greater
 * than the array length to generate the exception.
 * Demonstrate the exception and handle it using try-catch blocks
 * for ArrayIndexOutOfBoundsException and RuntimeException.
 */

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String[] names) {
        // Access an index outside the valid array range
        System.out.println("Name: " + names[names.length]);
    }

    // Method to demonstrate exception handling
    public static void handleException(String[] names) {
        try {
            // Access an invalid array index
            System.out.println("Name: " + names[names.length]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles an invalid array index
            System.out.println("ArrayIndexOutOfBoundsException handled!");
            System.out.println("Error: The array index is out of bounds.");

        } catch (RuntimeException e) {
            // Handles other runtime exceptions
            System.out.println("RuntimeException handled: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of names
        System.out.print("Enter the number of names: ");
        int size = sc.nextInt();

        // Create an array to store names
        String[] names = new String[size];

        // Take names as input from the user
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        System.out.println("\nCalling method to generate the exception:");

        // Catch the exception here so the program can continue
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nCalling method to handle the exception:");

        // Handle the exception inside the method
        handleException(names);

        System.out.println("Program continues normally.");

        sc.close();
    }
}