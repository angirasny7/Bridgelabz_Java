package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program that takes a sentence as input
 * and returns the longest word in the sentence.
 */

public class LongestWord {

    // Method to find the longest word in a sentence
    public static String findLongestWord(String text) {
        String longestWord = "";
        String currentWord = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                currentWord = currentWord + ch;
            } else {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }

                currentWord = "";
            }
        }

        // Check the last word after the loop ends
        if (currentWord.length() > longestWord.length()) {
            longestWord = currentWord;
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String longest = findLongestWord(sentence);

        if (longest.isEmpty()) {
            System.out.println("No words found in the sentence.");
        } else {
            System.out.println("Longest word: " + longest);
            System.out.println("Length: " + longest.length());
        }

        sc.close();
    }
}