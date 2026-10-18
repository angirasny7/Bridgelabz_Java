package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates the sum of positive numbers until 0 or a negative number is entered.
 */

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;

        // Continue accepting numbers until the loop is terminated
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = input.nextDouble();

            // Stop if the number is 0 or negative
            if (number <= 0) {
                break;
            }

            total += number;
        }

        System.out.println("The total sum is: " + total);

        input.close();
    }
}
