package Exceptions.BasicExceptionHandling;
import java.util.Scanner;
public class FinallyBlockDivision {
    /*
     * Problem: Perform integer division and handle division by zero.
     * The finally block must always print "Operation completed".
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter numerator and denominator: ");
            int a = sc.nextInt(), b = sc.nextInt();
            try {
                System.out.println("Result: " + (a / b));
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            } finally {
                System.out.println("Operation completed");
            }
        }
    }
}
