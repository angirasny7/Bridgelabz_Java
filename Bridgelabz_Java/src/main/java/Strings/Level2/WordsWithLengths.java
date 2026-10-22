package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Split the input text into words without using the built-in split()
 * method. Return the words and their corresponding lengths in a
 * 2D String array, and display the result in tabular format.
 */

public class WordsWithLengths {

    // Method to find the length of a String without using length()
    public static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to count the number of words
    public static int countWords(String text) {
        int length = findLength(text);
        int words = 0;
        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !inWord) {
                words++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }

        return words;
    }

    // Method to split text into words without using split()
    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = countWords(text);

        String[] words = new String[wordCount];

        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i <= length; i++) {

            if (i == length || text.charAt(i) == ' ') {

                if (start < i) {
                    String word = "";

                    for (int j = start; j < i; j++) {
                        word = word + text.charAt(j);
                    }

                    words[wordIndex] = word;
                    wordIndex++;
                }

                start = i + 1;
            }
        }

        return words;
    }

    // Method to create a 2D String array containing words and their lengths
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];

            int wordLength = findLength(words[i]);

            // Convert the integer length into a String
            result[i][1] = String.valueOf(wordLength);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        // Split the text using the user-defined method
        String[] words = splitText(text);

        // Store each word and its length in a 2D array
        String[][] result = getWordsWithLengths(words);

        // Display the result in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");

        for (int i = 0; i < result.length; i++) {
            String word = result[i][0];

            // Convert the String length back to an Integer
            int length = Integer.parseInt(result[i][1]);

            System.out.println(word + "\t\t" + length);
        }

        sc.close();
    }
}