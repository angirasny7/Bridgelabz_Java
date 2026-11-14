package Exceptions.AdvancedExceptionHandling;
import java.io.IOException;
public class CheckedAndUncheckedDemo {
    /*
     * Problem: Process data and demonstrate checked and unchecked exceptions.
     * Handle IOException and IllegalArgumentException separately in main.
     */
    public static void processData(String data) throws IOException {
        if (data == null || data.isBlank()) throw new IOException("Input data is empty");
        if (data.length() < 3)
            throw new IllegalArgumentException("Input data must contain at least 3 characters");
        System.out.println("Processed data: " + data.toUpperCase());
    }
    public static void main(String[] args) {
        String[] inputs = {"Java", "Hi", ""};
        for (String input : inputs) {
            try {
                processData(input);
            } catch (IOException e) {
                System.out.println("Checked exception: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Unchecked exception: " + e.getMessage());
            }
        }
    }
}
