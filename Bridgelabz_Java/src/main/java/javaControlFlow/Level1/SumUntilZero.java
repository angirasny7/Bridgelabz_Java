package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates the sum of numbers entered until the user enters 0.
 */

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;

        // Read the first number
        System.out.print("Enter a number (0 to stop): ");
        double number = input.nextDouble();

        // Add numbers until the user enters 0
        while (number != 0) {
            total += number;

            System.out.print("Enter a number (0 to stop): ");
            number = input.nextDouble();
        }

        System.out.println("The total sum is: " + total);

        input.close();
    }
}
