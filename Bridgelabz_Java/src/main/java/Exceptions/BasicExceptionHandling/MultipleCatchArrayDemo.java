package Exceptions.BasicExceptionHandling;
import java.util.Scanner;
public class MultipleCatchArrayDemo {
    /*
     * Problem: Access an array element using a user-entered index.
     * Handle null arrays and indexes outside the array bounds.
     */
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter index: ");
            int index = sc.nextInt();
            try {
                System.out.println("Value at index " + index + ": " + numbers[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid index!");
            } catch (NullPointerException e) {
                System.out.println("Array is not initialized!");
            }
        }
    }
}
