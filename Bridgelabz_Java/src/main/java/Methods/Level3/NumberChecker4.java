package Methods.Level3;

import java.util.Scanner;

public class NumberChecker4 {

    // Check whether a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Check whether a number is neon
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == number;
    }

    // Check whether a number is a spy number
    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;

        do {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        } while (number > 0);

        return sum == product;
    }

    // Check whether a number is automorphic
    public static boolean isAutomorphic(int number) {
        long square = (long) number * number;
        int temp = number;

        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }

            temp /= 10;
            square /= 10;
        }

        return true;
    }

    // Check whether a number is a buzz number
    public static boolean isBuzz(int number) {
        return number > 0 && (number % 7 == 0 || number % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            sc.close();
            return;
        }

        System.out.println("Is Prime Number? " + isPrime(number));
        System.out.println("Is Neon Number? " + isNeon(number));
        System.out.println("Is Spy Number? " + isSpy(number));
        System.out.println("Is Automorphic Number? " + isAutomorphic(number));
        System.out.println("Is Buzz Number? " + isBuzz(number));

        sc.close();
    }
}