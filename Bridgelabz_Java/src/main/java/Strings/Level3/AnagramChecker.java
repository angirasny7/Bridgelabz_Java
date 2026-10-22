
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Check whether two texts are anagrams.
 * Compare their lengths and character frequencies.
 */

public class AnagramChecker {

    // Method to check whether two texts are anagrams
    public static boolean areAnagrams(String text1, String text2) {

        // Step 1: Check whether lengths are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays for ASCII characters
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Step 3: Count character frequencies in both texts
        for (int i = 0; i < text1.length(); i++) {
            frequency1[text1.charAt(i)]++;
            frequency2[text2.charAt(i)]++;
        }

        // Step 4: Compare the frequency arrays
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the two texts as input
        System.out.print("Enter the first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter the second text: ");
        String text2 = sc.nextLine();

        // Check whether the texts are anagrams
        boolean result = areAnagrams(text1, text2);

        // Display the result
        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }

        sc.close();
    }
}
