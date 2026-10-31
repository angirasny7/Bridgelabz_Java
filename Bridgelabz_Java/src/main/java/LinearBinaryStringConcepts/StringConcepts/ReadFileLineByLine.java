package LinearBinaryStringConcepts.StringConcepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {

        // Specify the file path
        String filePath = "Bridgelabz_Java/src/main/java/sample.txt";

        // Use try-with-resources to automatically close the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Read the file one line at a time
            while ((line = br.readLine()) != null) {

                // Print the current line
                System.out.println(line);
            }

        } catch (IOException e) {

            // Handle file reading errors
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
