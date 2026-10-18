package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Checks whether a number is prime.
 */

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        boolean isPrime = number > 1;

        // Check for divisors from 2 up to the square root of the number
        for (int i = 2; i <= number / i && isPrime; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is not a Prime Number.");
        }

        input.close();
    }
}
