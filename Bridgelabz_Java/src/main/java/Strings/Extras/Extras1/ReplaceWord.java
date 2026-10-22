package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to replace a given word with another word
 * in a sentence without using the built-in replace() method.
 */

public class ReplaceWord {

    // Method to replace all occurrences of a word
    public static String replaceWord(
            String sentence, String oldWord, String newWord) {

        if (oldWord.isEmpty()) {
            return sentence;
        }

        String result = "";
        int i = 0;

        while (i < sentence.length()) {

            boolean matches = false;
            int end = i + oldWord.length();

            // Check whether the old word fits within the sentence
            if (end <= sentence.length()) {
                matches = true;

                // Compare characters one by one
                for (int j = 0; j < oldWord.length(); j++) {
                    if (sentence.charAt(i + j) != oldWord.charAt(j)) {
                        matches = false;
                        break;
                    }
                }
            }

            // Check the left word boundary
            boolean leftBoundary = (i == 0)
                    || !Character.isLetterOrDigit(sentence.charAt(i - 1));

            // Check the right word boundary safely
            boolean rightBoundary = (end >= sentence.length())
                    || !Character.isLetterOrDigit(sentence.charAt(end));

            if (matches && leftBoundary && rightBoundary) {
                result = result + newWord;
                i = end;
            } else {
                result = result + sentence.charAt(i);
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified sentence: " + modifiedSentence);

        sc.close();
    }
}