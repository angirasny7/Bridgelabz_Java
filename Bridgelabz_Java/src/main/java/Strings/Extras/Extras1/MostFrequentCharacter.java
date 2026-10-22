package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Write a Java program to find the most frequent character
 * in a given string.
 */

public class MostFrequentCharacter {

    // Method to find the most frequent character
    public static char findMostFrequentCharacter(String text) {
        int maxCount = 0;
        char mostFrequent = text.charAt(0);

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int count = 0;

            // Count occurrences of the current character
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current) {
                    count++;
                }
            }

            // Update the most frequent character
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = current;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        if (text.isEmpty()) {
            System.out.println("The string is empty.");
        } else {
            char result = findMostFrequentCharacter(text);
            System.out.println("Most Frequent Character: '" + result + "'");
        }

        sc.close();
    }
}