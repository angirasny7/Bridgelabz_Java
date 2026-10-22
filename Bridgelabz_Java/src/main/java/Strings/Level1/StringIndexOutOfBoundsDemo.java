package Strings.Level1;
/*
 * Question:
 * Write a program to demonstrate StringIndexOutOfBoundsException.
 * Take a string as user input and access an index beyond its length
 * using charAt() to generate the exception.
 * Then handle the exception using a try-catch block.
 */

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        System.out.println("Character: " + text.charAt(text.length()));
    }

    // Method to handle the exception
    public static void handleException(String text) {
        try {
            System.out.println("Character: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled!");
            System.out.println("Error: The index is outside the valid string range.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("\nCalling method to generate the exception:");

        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nCalling method to handle the exception:");

        handleException(text);

        System.out.println("Program continues normally.");

        sc.close();
    }
}