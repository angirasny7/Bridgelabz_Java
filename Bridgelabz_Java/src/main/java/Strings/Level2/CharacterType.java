package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Identify each character in a string as Vowel, Consonant, or Not a Letter.
 * Store each character and its type in a 2D String array and display
 * the result in tabular format.
 */

public class CharacterType {

    // Method to check whether a character is a vowel, consonant, or not a letter
    public static String checkCharacter(char ch) {

        // Convert uppercase letters to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check whether the character is an English letter
        if (ch >= 'a' && ch <= 'z') {

            // Check whether the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }

        } else {
            return "Not a Letter";
        }
    }

    // Method to store each character and its type in a 2D String array
    public static String[][] findCharacterTypes(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    // Method to display the 2D String array in tabular format
    public static void displayTable(String[][] result) {

        System.out.printf("%-15s %-20s%n", "Character", "Character Type");
        System.out.println("-----------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-15s %-20s%n",
                    result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String[][] result = findCharacterTypes(text);

        System.out.println("\nCharacter Classification:");
        displayTable(result);

        sc.close();
    }
}