package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to check whether a given string
 * is a palindrome.
 */

public class PalindromeString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        boolean isPalindrome = true;

        int left = 0;
        int right = text.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }

        sc.close();
    }
}