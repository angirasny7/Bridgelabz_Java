package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to toggle the case of each character
 * in a string. Convert uppercase letters to lowercase and
 * lowercase letters to uppercase.
 */

public class ToggleCase {

    // Method to toggle the case of each character
    public static String toggleCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert uppercase to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            // Convert lowercase to uppercase
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result = result + ch;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String toggled = toggleCase(text);

        System.out.println("Original string: " + text);
        System.out.println("String after toggling case: " + toggled);

        sc.close();
    }
}