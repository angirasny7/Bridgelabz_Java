package Exceptions.BasicExceptionHandling;
import java.util.Scanner;
public class NestedTryCatchDemo {
    /*
     * Problem: Read an array index and divisor from the user.
     * Use nested try-catch blocks for invalid indexes and division by zero.
     */
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter index and divisor: ");
            int index = sc.nextInt(), divisor = sc.nextInt();
            try {
                int value = numbers[index];
                try {
                    System.out.println("Division result: " + (value / divisor));
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        }
    }
}
