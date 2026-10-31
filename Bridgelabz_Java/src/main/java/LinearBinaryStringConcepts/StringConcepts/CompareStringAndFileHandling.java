
package LinearBinaryStringConcepts.StringConcepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CompareStringAndFileHandling {

    // Count the total number of words in a file
    static long countWords(BufferedReader br) throws IOException {

        long wordCount = 0;
        String line;

        // Read the file line by line
        while ((line = br.readLine()) != null) {

            // Ignore empty lines
            if (!line.trim().isEmpty()) {

                // Split the line using one or more whitespace characters
                String[] words = line.trim().split("\\s+");

                // Add the number of words in the current line
                wordCount += words.length;
            }
        }

        return wordCount;
    }

    // Read file using FileReader and count words
    static long readUsingFileReader(String filePath) throws IOException {

        try (BufferedReader br = new BufferedReader(
                new FileReader(filePath))) {

            return countWords(br);
        }
    }

    // Read file using InputStreamReader and count words
    static long readUsingInputStreamReader(String filePath) throws IOException {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath),
                        StandardCharsets.UTF_8))) {

            return countWords(br);
        }
    }

    public static void main(String[] args) {

        int iterations = 1_000_000;

        // ==========================================
        // PART 1: Compare StringBuilder and StringBuffer
        // ==========================================

        // Create StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Record starting time
        long startBuilder = System.nanoTime();

        // Append hello one million times
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }

        // Record ending time
        long endBuilder = System.nanoTime();

        // Calculate execution time in milliseconds
        long builderTime = (endBuilder - startBuilder) / 1_000_000;

        // Create StringBuffer object
        StringBuffer sbf = new StringBuffer();

        // Record starting time
        long startBuffer = System.nanoTime();

        // Append hello one million times
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }

        // Record ending time
        long endBuffer = System.nanoTime();

        // Calculate execution time in milliseconds
        long bufferTime = (endBuffer - startBuffer) / 1_000_000;

        // Display string concatenation results
        System.out.println("===== STRING CONCATENATION =====");

        System.out.println("StringBuilder Length: " + sb.length());
        System.out.println("StringBuffer Length: " + sbf.length());

        System.out.println("StringBuilder Time: " + builderTime + " ms");
        System.out.println("StringBuffer Time: " + bufferTime + " ms");

        // ==========================================
        // PART 2: Compare FileReader and InputStreamReader
        // ==========================================

        // Specify the large file path
        String filePath = "Bridgelabz_Java/large.txt";

        try {

            // Read file using FileReader
            long startFileReader = System.nanoTime();

            long fileReaderCount = readUsingFileReader(filePath);

            long endFileReader = System.nanoTime();

            long fileReaderTime =
                    (endFileReader - startFileReader) / 1_000_000;

            // Read file using InputStreamReader
            long startInputStreamReader = System.nanoTime();

            long inputStreamReaderCount =
                    readUsingInputStreamReader(filePath);

            long endInputStreamReader = System.nanoTime();

            long inputStreamReaderTime =
                    (endInputStreamReader - startInputStreamReader)
                            / 1_000_000;

            // Display file reading results
            System.out.println("\n===== FILE READING =====");

            System.out.println(
                    "FileReader Word Count: " + fileReaderCount);

            System.out.println(
                    "InputStreamReader Word Count: " + inputStreamReaderCount);

            System.out.println(
                    "FileReader Time: " + fileReaderTime + " ms");

            System.out.println(
                    "InputStreamReader Time: " + inputStreamReaderTime + " ms");

            // Compare word counts
            if (fileReaderCount == inputStreamReaderCount) {
                System.out.println("Both readers produced the same word count.");
            } else {
                System.out.println("Word counts do not match.");
            }

        } catch (IOException e) {

            // Handle file reading errors
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
