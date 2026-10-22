
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Find unique characters in a string using charAt()
 * without using the String length() method.
 * Return the unique characters as a 1D character array.
 */

public class UniqueCharacters {

    // Method to find string length without using length()
    public static int findLength(String text) {

        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to find unique characters and return a 1D array
    public static char[] findUniqueCharacters(String text) {

        int size = findLength(text);

        // Array to store unique characters
        char[] temp = new char[size];
        int uniqueCount = 0;

        // Check each character against previous characters
        for (int i = 0; i < size; i++) {

            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // Store the character if it has not appeared before
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create an array of the exact required size
        char[] uniqueCharacters = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = temp[i];
        }

        return uniqueCharacters;
    }

    // Method to display the unique characters
    public static void displayCharacters(char[] characters) {

        System.out.print("Unique characters: ");

        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find and display unique characters
        char[] uniqueCharacters = findUniqueCharacters(text);

        displayCharacters(uniqueCharacters);

        sc.close();
    }
}
