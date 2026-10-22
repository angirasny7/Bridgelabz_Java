package Strings.Level1;

import java.util.Scanner;

/*
 * Question:
 * Write a program to convert the complete text to lowercase and compare
 * the results. Use charAt() to convert uppercase characters to lowercase
 * using ASCII values. Compare the user-defined result with the built-in
 * String method and display whether both results are equal.
 */

public class ConvertToLowerCase {

    // Method to convert uppercase characters to lowercase using ASCII values
    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert uppercase letters to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result = result + ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the complete text, including spaces
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Convert using the user-defined method
        String result1 = convertToLowerCase(text);

        // Convert using the built-in method
        String result2 = text.toLowerCase();

        // Display both results
        System.out.println("Lowercase using user-defined method: " + result1);
        System.out.println("Lowercase using toLowerCase(): " + result2);

        // Compare both results
        boolean result = compareStrings(result1, result2);

        System.out.println("Are both results equal? " + result);

        sc.close();
    }
}