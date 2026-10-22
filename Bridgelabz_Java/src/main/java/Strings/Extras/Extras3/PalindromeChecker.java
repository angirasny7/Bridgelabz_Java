
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Check whether a given word, phrase, or sequence
 * is a palindrome.
 * Organize the program into separate functions
 * for input, checking, and displaying the result.
 */

public class PalindromeChecker {

    // Method to take input from the user
    public static String takeInput(Scanner sc) {
        System.out.print("Enter a word or phrase: ");
        return sc.nextLine();
    }

    // Method to check whether the string is a palindrome
    public static boolean isPalindrome(String str) {

        // Ignore spaces and letter case
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Method to display the result
    public static void displayResult(String str, boolean result) {

        if (result) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        String input = takeInput(sc);

        // Check the palindrome condition
        boolean result = isPalindrome(input);

        // Display the result
        displayResult(input, result);

        sc.close();
    }
}
