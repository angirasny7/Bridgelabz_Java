package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Accept two strings and check whether they are anagrams
 * of each other.
 */

public class AnagramCheck {

    // Method to check whether two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {

        // Convert both strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Remove spaces from both strings
        str1 = removeSpaces(str1);
        str2 = removeSpaces(str2);

        // Anagrams must have the same length
        if (str1.length() != str2.length()) {
            return false;
        }

        boolean[] visited = new boolean[str2.length()];

        // Check each character in the first string
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            boolean found = false;

            // Find a matching unused character in the second string
            for (int j = 0; j < str2.length(); j++) {
                if (ch == str2.charAt(j) && !visited[j]) {
                    visited[j] = true;
                    found = true;
                    break;
                }
            }

            // If no matching character exists, they are not anagrams
            if (!found) {
                return false;
            }
        }

        return true;
    }

    // Method to remove spaces without using replace()
    public static String removeSpaces(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                result = result + text.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        sc.close();
    }
}