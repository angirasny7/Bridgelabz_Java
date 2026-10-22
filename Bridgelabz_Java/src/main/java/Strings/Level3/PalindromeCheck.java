
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Check whether a text is a palindrome using three methods:
 * 1. Iterative comparison
 * 2. Recursive comparison
 * 3. Reversing and comparing character arrays
 */

public class PalindromeCheck {

    // Logic 1: Check palindrome using a loop
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Logic 2: Check palindrome using recursion
    public static boolean isPalindromeRecursive(
            String text, int start, int end) {

        // Base case: all character pairs have matched
        if (start >= end) {
            return true;
        }

        // If characters do not match, it is not a palindrome
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Compare the next pair of characters
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Reverse the string using charAt()
    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }

        return reverse;
    }

    // Compare the original and reversed character arrays
    public static boolean isPalindromeUsingArrays(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    // Display the result of each logic
    public static void displayResult(String method, boolean result) {

        if (result) {
            System.out.println(method + ": The text is a palindrome.");
        } else {
            System.out.println(method + ": The text is not a palindrome.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a word or text: ");
        String text = sc.nextLine();

        // Logic 1: Iterative comparison
        boolean result1 = isPalindromeIterative(text);

        // Logic 2: Recursive comparison
        boolean result2 = isPalindromeRecursive(
                text, 0, text.length() - 1);

        // Logic 3: Character array comparison
        boolean result3 = isPalindromeUsingArrays(text);

        // Display all three results
        System.out.println("\nPalindrome Check Results:");

        displayResult("Logic 1 (Iterative)", result1);
        displayResult("Logic 2 (Recursive)", result2);
        displayResult("Logic 3 (Character Arrays)", result3);

        sc.close();
    }
}
