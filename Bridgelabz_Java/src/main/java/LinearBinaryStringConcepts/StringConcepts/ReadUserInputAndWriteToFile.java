package LinearBinaryStringConcepts.StringConcepts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadUserInputAndWriteToFile {

    public static void main(String[] args) {

        // Specify the output file path
        String filePath = "Bridgelabz_Java/userInput.txt";

        // InputStreamReader converts console byte input into characters
        // BufferedReader reads user input line by line
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));

                // FileWriter creates the file and writes data into it
                // BufferedWriter improves writing efficiency
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(filePath))
        ) {

            String input;

            System.out.println("Enter text to write into the file.");
            System.out.println("Type 'exit' to stop.");

            // Continue reading input until the user enters exit
            while (true) {

                System.out.print("Enter text: ");

                // Read one line from the console
                input = br.readLine();

                // Stop accepting input when the user enters exit
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write the entered text into the file
                bw.write(input);

                // Move to the next line in the file
                bw.newLine();
            }

            // Display success message
            System.out.println("Data successfully written to " + filePath);

        } catch (IOException e) {

            // Handle input and file writing errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}
