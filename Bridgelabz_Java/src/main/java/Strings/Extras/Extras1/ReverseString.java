package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to reverse a given string
 * without using any built-in reverse functions.
 */

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String reversed = "";

        // Traverse the string from the last character to the first
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        System.out.println("Original string: " + text);
        System.out.println("Reversed string: " + reversed);

        sc.close();
    }
}