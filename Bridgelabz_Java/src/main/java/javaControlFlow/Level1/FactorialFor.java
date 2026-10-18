package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates the factorial of a non-negative integer using a for loop.
 */

public class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number >= 0) {
            long factorial = 1;

            // Calculate the factorial using a for loop
            for (int counter = 1; counter <= number; counter++) {
                factorial *= counter;
            }

            System.out.println("Factorial of " + number + " is: " + factorial);
        } else {
            System.out.println("Please enter a non-negative integer.");
        }

        input.close();
    }
}
