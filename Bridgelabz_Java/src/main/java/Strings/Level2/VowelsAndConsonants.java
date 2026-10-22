package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Write a program to find vowels and consonants in a string
 * and display their counts.
 */

public class VowelsAndConsonants {

    // Method to check whether a character is a vowel, consonant, or not a letter
    public static String checkCharacter(char ch) {

        // Convert uppercase letters to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check whether the character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check whether the letter is a vowel
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

    // Method to count vowels and consonants in a string
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            String result = checkCharacter(ch);

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        // Index 0 stores vowels; index 1 stores consonants
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        int[] result = countVowelsAndConsonants(text);

        System.out.println("Number of vowels: " + result[0]);
        System.out.println("Number of consonants: " + result[1]);

        sc.close();
    }
}