package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to remove all duplicate characters
 * from a given string and return the modified string.
 */

public class RemoveDuplicates {

    // Method to remove duplicate characters
    public static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isDuplicate = false;

            // Check whether the character already exists in result
            for (int j = 0; j < result.length(); j++) {
                if (current == result.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            // Add the character only if it is not a duplicate
            if (!isDuplicate) {
                result = result + current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String result = removeDuplicates(text);

        System.out.println("Original string: " + text);
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}