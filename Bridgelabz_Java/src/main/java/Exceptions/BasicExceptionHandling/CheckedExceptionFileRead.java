package Exceptions.BasicExceptionHandling;
import java.io.*;
public class CheckedExceptionFileRead {
    /*
     * Problem: Read data.txt and handle IOException if the file is unavailable.
     * Print the file contents when reading succeeds.
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
