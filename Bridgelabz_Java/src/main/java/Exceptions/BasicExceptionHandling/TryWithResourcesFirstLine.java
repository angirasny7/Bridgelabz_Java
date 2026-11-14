package Exceptions.BasicExceptionHandling;
import java.io.*;
public class TryWithResourcesFirstLine {
    /*
     * Problem: Read the first line of info.txt using BufferedReader.
     * Use try-with-resources so the reader closes automatically.
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String line = reader.readLine();
            if (line != null) System.out.println(line);
            else System.out.println("The file is empty.");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
