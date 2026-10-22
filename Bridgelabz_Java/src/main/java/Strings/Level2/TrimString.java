package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Trim leading and trailing spaces from a string using charAt().
 * Create a substring manually and compare the result with the
 * built-in trim() method.
 */

public class TrimString {

    // Method to find the starting and ending indexes after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Find the first non-space character
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }

        // Find the last non-space character
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        // Return the start index and exclusive end index
        return new int[]{start, end + 1};
    }

    // Method to create a substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string with leading and trailing spaces:");
        String text = sc.nextLine();

        // Find the indexes after trimming
        int[] indexes = findTrimIndexes(text);

        int start = indexes[0];
        int end = indexes[1];

        // Trim using the user-defined substring method
        String userTrimmed = createSubstring(text, start, end);

        // Trim using the built-in trim() method
        String builtInTrimmed = text.trim();

        // Compare both results
        boolean result = compareStrings(userTrimmed, builtInTrimmed);

        System.out.println("\nOriginal string: [" + text + "]");
        System.out.println("User-defined trim: [" + userTrimmed + "]");
        System.out.println("Built-in trim:     [" + builtInTrimmed + "]");
        System.out.println("Are both strings equal? " + result);

        sc.close();
    }
}