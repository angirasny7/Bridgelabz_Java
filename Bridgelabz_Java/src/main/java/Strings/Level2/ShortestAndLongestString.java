package Strings.Level2;

import java.util.Scanner;

/*
 * Question:
 * Split the input text into words without using the built-in split()
 * method. Find the shortest and longest words using a 2D String array
 * that stores each word and its corresponding length.
 */

public class ShortestAndLongestString {

    // Method to find String length without using length()
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

    // Method to count words in the text
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

    // Method to create a 2D array containing words and their lengths
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    /*
     * Method to find the shortest and longest words.
     * Returns an int array:
     * index 0 = position of the shortest word
     * index 1 = position of the longest word
     */
    public static int[] findShortestAndLongest(String[][] wordData) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordData.length; i++) {
            int currentLength = Integer.parseInt(wordData[i][1]);
            int shortestLength = Integer.parseInt(wordData[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordData[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }

            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] words = splitText(text);

        if (words.length == 0) {
            System.out.println("No words found in the input.");
            sc.close();
            return;
        }

        String[][] wordData = getWordsWithLengths(words);

        int[] result = findShortestAndLongest(wordData);

        int shortestIndex = result[0];
        int longestIndex = result[1];

        System.out.println("\nWord\t\tLength");
        System.out.println("------------------------");

        for (int i = 0; i < wordData.length; i++) {
            System.out.println(
                    wordData[i][0] + "\t\t" +
                            Integer.parseInt(wordData[i][1])
            );
        }

        System.out.println("\nShortest word: " + wordData[shortestIndex][0]);
        System.out.println("Length: " + wordData[shortestIndex][1]);

        System.out.println("\nLongest word: " + wordData[longestIndex][0]);
        System.out.println("Length: " + wordData[longestIndex][1]);

        sc.close();
    }
}