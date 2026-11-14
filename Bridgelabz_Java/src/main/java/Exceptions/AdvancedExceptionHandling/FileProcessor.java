package Exceptions.AdvancedExceptionHandling;
import java.io.*;
import java.util.List;
public class FileProcessor {
    /*
     * Problem: Read every file path supplied in a list.
     * Use try-with-resources to close each BufferedReader automatically.
     */
    public void processFiles(List<String> paths) {
        for (String path : paths) {
            System.out.println("\\nReading: " + path);
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) System.out.println(line);
            } catch (IOException e) {
                System.out.println("Unable to read file: " + path);
            }
        }
    }
    public static void main(String[] args) {
        new FileProcessor().processFiles(List.of("data.txt", "info.txt"));
    }
}
