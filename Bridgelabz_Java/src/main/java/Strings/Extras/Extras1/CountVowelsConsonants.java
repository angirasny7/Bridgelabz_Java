package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to count the number of vowels
 * and consonants in a given string.
 */

public class CountVowelsConsonants {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert uppercase letters to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            // Check whether the character is an English letter
            if (ch >= 'a' && ch <= 'z') {

                // Check whether it is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);

        sc.close();
    }
}