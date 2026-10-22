
package Strings.Extras.Extras3;

import java.util.Scanner;

/*
 * Problem:
 * Check whether a given number is a prime number.
 * Use a separate function to perform the prime check
 * and return the result.
 */

public class PrimeNumberChecker {

    // Method to check whether a number is prime
    public static boolean isPrime(int number) {

        // Numbers less than 2 are not prime
        if (number < 2) {
            return false;
        }

        // Check divisibility from 2 up to the square root
        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Call the prime-checking method
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        sc.close();
    }
}
