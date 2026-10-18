package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates the sum of n natural numbers using a loop and a formula,
 * then compares both results.
 */

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n >= 1) {
            // Calculate the sum using a while loop
            int counter = 1;
            long loopSum = 0;

            while (counter <= n) {
                loopSum += counter;
                counter++;
            }

            // Calculate the sum using the formula
            long formulaSum = (long) n * (n + 1) / 2;

            // Compare both results
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Are both results equal? " + (loopSum == formulaSum));
        } else {
            System.out.println("Please enter a natural number greater than 0.");
        }

        input.close();
    }
}
