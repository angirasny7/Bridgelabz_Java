package javaControlFlow.Level3;

import java.util.Scanner;

/*
 * Checks whether a number is an abundant number.
 */

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = 0;

            // Calculate the sum of proper divisors
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }

            if (sum > number) {
                System.out.println(number + " is an Abundant Number.");
            } else {
                System.out.println(number + " is not an Abundant Number.");
            }
        }

        input.close();
    }
}
