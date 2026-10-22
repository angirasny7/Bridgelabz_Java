
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Find the frequency of characters in a string using unique
 * characters and display the result.
 *
 * Use nested loops to find unique characters and an ASCII
 * frequency array to calculate character frequencies.
 */

public class CharacterFrequencyUsingUniqueCharacters {

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {

        int n = text.length();

        // Temporary array to store unique characters
        char[] temp = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {

            char current = text.charAt(i);
            boolean isUnique = true;

            // Check whether the character appeared earlier
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create an array of the exact required size
        char[] unique = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    // Method to find character frequencies and return a 2D array
    public static String[][] findFrequency(String text) {

        // Array to store frequencies of ASCII characters
        int[] frequency = new int[256];

        // Count the frequency of every character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Find the unique characters
        char[] unique = uniqueCharacters(text);

        // Create a 2D array: character and frequency
        String[][] result = new String[unique.length][2];

        // Store each unique character and its frequency
        for (int i = 0; i < unique.length; i++) {
            char ch = unique[i];

            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
        }

        return result;
    }

    // Method to display character frequencies
    public static void displayFrequency(String[][] result) {

        System.out.printf("%-15s %s%n", "Character", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i < result.length; i++) {

            String character = result[i][0];

            // Display spaces clearly
            if (character.equals(" ")) {
                character = "[space]";
            }

            System.out.printf("%-15s %s%n",
                    character, result[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find character frequencies
        String[][] result = findFrequency(text);

        // Display the result
        displayFrequency(result);

        sc.close();
    }
}
