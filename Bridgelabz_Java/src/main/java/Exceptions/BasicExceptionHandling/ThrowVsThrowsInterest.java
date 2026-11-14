package Exceptions.BasicExceptionHandling;
import java.util.Scanner;
public class ThrowVsThrowsInterest {
    /*
     * Problem: Calculate simple interest after validating amount and rate.
     * Throw IllegalArgumentException for negative values and handle it in main.
     */
    public static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {
        if (amount < 0 || rate < 0 || years < 0)
            throw new IllegalArgumentException();
        return amount * rate * years / 100.0;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter amount, rate and years: ");
            double amount = sc.nextDouble();
            double rate = sc.nextDouble();
            int years = sc.nextInt();
            try {
                System.out.println("Calculated interest: " + calculateInterest(amount, rate, years));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: Amount and rate must be positive");
            }
        }
    }
}
