package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Calculates the power of a number using a for loop.
 */

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the power: ");
        int power = input.nextInt();

        if (power < 0) {
            System.out.println("Please enter a non-negative power.");
        } else {
            long result = 1;

            for (int i = 1; i <= power; i++) {
                result *= number;
            }

            System.out.println(number + " raised to the power "
                    + power + " is: " + result);
        }

        input.close();
    }
}
