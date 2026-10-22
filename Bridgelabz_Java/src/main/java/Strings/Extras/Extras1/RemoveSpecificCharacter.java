package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to remove all occurrences
 * of a specific character from a string.
 */

public class RemoveSpecificCharacter {

    // Method to remove all occurrences of a character
    public static String removeCharacter(String text, char target) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Append only characters that do not match the target
            if (ch != target) {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.print("Character to remove: ");
        char target = sc.nextLine().charAt(0);

        String result = removeCharacter(text, target);

        System.out.println("Modified String: \"" + result + "\"");

        sc.close();
    }
}