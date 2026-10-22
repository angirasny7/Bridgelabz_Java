package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Write a program to split the text into words without using the
 * built-in split() method. Compare the user-defined method's result
 * with the built-in split() method and display the result.
 */

public class SplitTextIntoWords {

    // Method to find the length of a string without using length()
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

    // Method to count the number of words in the text
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

    // Method to split the text into words without using split()
    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = countWords(text);

        String[] words = new String[wordCount];

        // Store the indexes of spaces in a 1D array
        int[] spaceIndexes = new int[length];
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }

        // Extract each word using the space indexes
        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i <= spaceCount; i++) {
            int end;

            if (i < spaceCount) {
                end = spaceIndexes[i];
            } else {
                end = length;
            }

            if (start < end) {
                String word = "";

                for (int j = start; j < end; j++) {
                    word = word + text.charAt(j);
                }

                words[wordIndex] = word;
                wordIndex++;
            }

            start = end + 1;
        }

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] array1, String[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        // Split using the user-defined method
        String[] userDefinedWords = splitText(text);

        // Split using the built-in split() method
        String trimmedText = text.trim();
        String[] builtInWords;

        if (trimmedText.isEmpty()) {
            builtInWords = new String[0];
        } else {
            builtInWords = trimmedText.split("\\s+");
        }

        System.out.println("\nWords using the user-defined method:");
        for (String word : userDefinedWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using the built-in split() method:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        boolean result = compareArrays(userDefinedWords, builtInWords);

        System.out.println("\nAre both arrays equal? " + result);

        sc.close();
    }
}