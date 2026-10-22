package Strings.Level1;

import java.util.Scanner;

/*
 * Question:
 * Write a program to demonstrate NumberFormatException.
 * Take user input as a String and use Integer.parseInt() to convert
 * it into an integer. If the input is not a valid integer, generate
 * NumberFormatException. Demonstrate the exception and handle it
 * using try-catch blocks for NumberFormatException and RuntimeException.
 */

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // Converts the string into an integer.
        // Invalid numeric input generates NumberFormatException.
        int number = Integer.parseInt(text);

        System.out.println("Number: " + number);
    }

    // Method to demonstrate exception handling
    public static void handleException(String text) {
        try {
            // Attempt to convert the string into an integer.
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);

        } catch (NumberFormatException e) {
            // Handles strings that cannot be converted into integers.
            System.out.println("NumberFormatException handled!");
            System.out.println("Error: The input is not a valid integer.");

        } catch (RuntimeException e) {
            // Handles other runtime exceptions.
            System.out.println("RuntimeException handled: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String text = sc.next();

        System.out.println("\nCalling method to generate the exception:");

        // Catch the exception here so the program can continue.
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nCalling method to handle the exception:");

        // Handle the exception inside the method.
        handleException(text);

        System.out.println("Program continues normally.");

        sc.close();
    }
}