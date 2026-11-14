package Exceptions.AdvancedExceptionHandling;
import java.io.*;
public class MultipleResourceFileMerge {
    /*
     * Problem: Read two files and write their combined contents to a third file.
     * Use try-with-resources to close both readers and the writer automatically.
     */
    public static void main(String[] args) {
        try (BufferedReader first = new BufferedReader(new FileReader("first.txt"));
             BufferedReader second = new BufferedReader(new FileReader("second.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("combined.txt"))) {
            String line;
            while ((line = first.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            while ((line = second.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Files combined successfully into combined.txt");
        } catch (IOException e) {
            System.out.println("Error while reading or writing files: " + e.getMessage());
        }
    }
}
