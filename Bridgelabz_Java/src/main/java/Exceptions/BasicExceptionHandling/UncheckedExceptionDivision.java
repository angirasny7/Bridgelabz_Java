package Exceptions.BasicExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UncheckedExceptionDivision {
    /*
     * Problem: Divide two user-entered numbers.
     * Handle invalid numeric input and division by zero.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid integers.");
        }
    }
}
