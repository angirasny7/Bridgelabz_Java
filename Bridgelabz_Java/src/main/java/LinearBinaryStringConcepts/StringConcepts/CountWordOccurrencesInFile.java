package LinearBinaryStringConcepts.StringConcepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountWordOccurrencesInFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Working Directory: " + System.getProperty("user.dir"));

        // Specify the file path
        String filePath = "Bridgelabz_Java/src/main/java/sample.txt";

        // Read the word whose occurrence needs to be counted
        System.out.print("Enter the word to search: ");
        String targetWord = sc.nextLine();

        // Initialize the occurrence counter
        int count = 0;

        // Open the file and read it line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Read each line until the end of the file
            while ((line = br.readLine()) != null) {

                // Split the line into individual words
                String[] words = line.split("\\s+");

                // Traverse each word in the current line
                for (String word : words) {

                    // Remove punctuation and compare words without case sensitivity
                    word = word.replaceAll("[^a-zA-Z0-9]", "");

                    if (word.equalsIgnoreCase(targetWord)) {

                        // Increment the counter when the word matches
                        count++;
                    }
                }
            }

            // Display the total number of occurrences
            System.out.println("Occurrences of \"" + targetWord + "\": " + count);

        } catch (IOException e) {

            // Handle file reading errors
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
