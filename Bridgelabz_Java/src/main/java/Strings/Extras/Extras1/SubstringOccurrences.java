package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to count how many times a given
 * substring occurs in a string.
 */

public class SubstringOccurrences {

    // Method to count substring occurrences
    public static int countOccurrences(String text, String substring) {
        int count = 0;
        int textLength = text.length();
        int subLength = substring.length();

        // An empty substring is not counted
        if (subLength == 0 || subLength > textLength) {
            return 0;
        }

        // Check every possible starting position
        for (int i = 0; i <= textLength - subLength; i++) {
            boolean match = true;

            // Compare characters with the substring
            for (int j = 0; j < subLength; j++) {
                if (text.charAt(i + j) != substring.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring to search: ");
        String substring = sc.nextLine();

        int count = countOccurrences(text, substring);

        System.out.println("Number of occurrences: " + count);

        sc.close();
    }
}