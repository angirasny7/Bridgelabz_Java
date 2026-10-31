package LinearBinaryStringConcepts.StringConcepts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConvertByteStreamToCharacterStream {

    public static void main(String[] args) {

        // Specify the file path
        String filePath = "Bridgelabz_Java/src/main/java/sample.txt";

        // Create FileInputStream to read bytes from the file
        // InputStreamReader converts bytes into characters using UTF-8
        // BufferedReader reads the characters efficiently line by line
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath),
                        StandardCharsets.UTF_8))) {

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
