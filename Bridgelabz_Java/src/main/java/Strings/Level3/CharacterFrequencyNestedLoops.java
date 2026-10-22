
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Find the frequency of characters in a string using nested
 * loops and display the result in a 1D String array.
 */

public class CharacterFrequencyNestedLoops {

    // Method to find character frequencies
    public static String[] findFrequency(String text) {

        // Convert the string into a character array
        char[] characters = text.toCharArray();

        int n = characters.length;

        // Array to store the frequency of each character
        int[] frequency = new int[n];

        // Count frequencies using nested loops
        for (int i = 0; i < n; i++) {

            // Skip characters already processed
            if (characters[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < n; j++) {

                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0';
                }
            }
        }

        // Count distinct characters
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            if (characters[i] != '0') {
                uniqueCount++;
            }
        }

        // Store characters and frequencies in a 1D String array
        String[] result = new String[uniqueCount];
        int index = 0;

        for (int i = 0; i < n; i++) {

            if (characters[i] != '0') {
                result[index] = characters[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find character frequencies
        String[] result = findFrequency(text);

        // Display the result
        System.out.println("Character Frequencies:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}
