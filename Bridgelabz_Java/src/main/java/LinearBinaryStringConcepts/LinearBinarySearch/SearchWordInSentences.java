package LinearBinaryStringConcepts.LinearBinarySearch;

import java.util.Scanner;

public class SearchWordInSentences {

    // Method to find the first sentence containing the target word
    static String searchWord(String[] sentences, String target) {

        // Traverse each sentence in the array
        for (int i = 0; i < sentences.length; i++) {

            // Split the sentence into individual words
            String[] words = sentences[i].split("\\s+");

            // Check each word in the current sentence
            for (String word : words) {

                // Remove punctuation before comparison
                word = word.replaceAll("[^a-zA-Z0-9]", "");

                // Compare words without considering case
                if (word.equalsIgnoreCase(target)) {

                    // Return the first matching sentence
                    return sentences[i];
                }
            }
        }

        // Return Not Found if the target word does not exist
        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize an array of sentences
        String[] sentences = {
                "Java is a programming language.",
                "Python is easy to learn.",
                "Java supports object-oriented programming.",
                "C++ is also a programming language."
        };

        // Read the target word from the user
        System.out.print("Enter the word to search: ");
        String target = sc.nextLine().trim();

        // Search for the target word
        String result = searchWord(sentences, target);

        // Display the result
        if (result.equals("Not Found")) {
            System.out.println("Word not found in any sentence.");
        } else {
            System.out.println("Matching Sentence: " + result);
        }

        sc.close();
    }
}
