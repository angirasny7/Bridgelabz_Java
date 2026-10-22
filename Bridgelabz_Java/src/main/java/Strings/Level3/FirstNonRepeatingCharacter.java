
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Find the first non-repeating character in a string.
 * Use an array of size 256 to store character frequencies.
 * Return the first character whose frequency is one.
 */

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeating(String text) {

        // Array to store the frequency of ASCII characters
        int[] frequency = new int[256];

        // Count the frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Find the first character with frequency one
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        // Return a special character if none is found
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find the first non-repeating character
        char result = findFirstNonRepeating(text);

        // Display the result
        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println(
                    "First non-repeating character: " + result);
        }

        sc.close();
    }
}
