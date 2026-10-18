package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates the sum of n natural numbers using a for loop and a formula,
 * then compares both results.
 */

public class SumNaturalNumbersFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n >= 1) {
            // Calculate the sum using a for loop
            long loopSum = 0;

            for (int counter = 1; counter <= n; counter++) {
                loopSum += counter;
            }

            // Calculate the sum using the formula
            long formulaSum = (long) n * (n + 1) / 2;

            // Compare both results
            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Are both results equal? " + (loopSum == formulaSum));
        } else {
            System.out.println("Please enter a natural number greater than 0.");
        }

        input.close();
    }
}
