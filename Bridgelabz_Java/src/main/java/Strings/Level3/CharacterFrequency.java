
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Find the frequency of characters in a string using charAt().
 * Return the characters and their frequencies in a 2D array.
 */

public class CharacterFrequency {

    // Method to find character frequencies and return a 2D array
    public static String[][] findFrequency(String text) {

        // Array to store the frequency of ASCII characters
        int[] frequency = new int[256];

        // Count the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Count the number of distinct characters
        int uniqueCount = 0;

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }

        // Create a 2D array for characters and their frequencies
        String[][] result = new String[uniqueCount][2];

        int index = 0;

        // Store each character and its frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);

                // Mark the character as processed
                frequency[ch] = 0;
                index++;
            }
        }

        return result;
    }

    // Method to display the character frequencies
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

        // Find the frequency of each character
        String[][] result = findFrequency(text);

        // Display the result
        displayFrequency(result);

        sc.close();
    }
}
