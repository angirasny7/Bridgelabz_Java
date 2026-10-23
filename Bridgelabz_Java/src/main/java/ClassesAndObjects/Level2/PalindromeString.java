
/*
 * Question: Check Palindrome String
 * Create a PalindromeChecker class with an attribute text.
 * Add methods to check whether the text is a palindrome
 * and display the result.
 */

package ClassesAndObjects.Level2;

import java.util.Scanner;

// Class to check whether a string is a palindrome
class PalindromeChecker {

    // Attribute to store the text
    String text;

    // Method to check whether the text is a palindrome
    boolean isPalindrome() {

        // Reverse the text using a loop
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        // Compare the original text with the reversed text
        return text.equalsIgnoreCase(reversed);
    }

    // Method to display the result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }
}

// Main class
public class PalindromeString {

    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the PalindromeChecker class
        PalindromeChecker checker = new PalindromeChecker();

        // Input the text
        System.out.print("Enter a string: ");
        checker.text = input.nextLine();

        // Display whether the text is a palindrome
        checker.displayResult();

        // Close the Scanner
        input.close();
    }
}
