package Methods.Level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker5 {

    // Find all factors of a number and store them in an array
    public static int[] findFactors(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Find the greatest factor
    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    // Find the sum of all factors
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            sum += factor;
        }

        return sum;
    }

    // Find the product of all factors
    public static long findProductOfFactors(int[] factors) {
        long product = 1;

        for (int factor : factors) {
            product *= factor;
        }

        return product;
    }

    // Find the product of the cubes of all factors
    public static double findProductOfCubes(int[] factors) {
        double product = 1;

        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }

        return product;
    }

    // Check whether a number is perfect
    public static boolean isPerfect(int number, int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }

        return number > 0 && sum == number;
    }

    // Check whether a number is abundant
    public static boolean isAbundant(int number, int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }

        return number > 0 && sum > number;
    }

    // Check whether a number is deficient
    public static boolean isDeficient(int number, int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }

        return number > 0 && sum < number;
    }

    // Calculate the factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;

        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }

        return fact;
    }

    // Check whether a number is strong
    public static boolean isStrong(int number) {
        if (number < 0) {
            return false;
        }

        int temp = number;
        int sum = 0;

        do {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        } while (temp > 0);

        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return;
        }

        int[] factors = findFactors(number);

        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + findSumOfFactors(factors));
        System.out.println("Product of factors: " + findProductOfFactors(factors));
        System.out.println("Product of cubes of factors: " + findProductOfCubes(factors));

        System.out.println("Is Perfect Number? " + isPerfect(number, factors));
        System.out.println("Is Abundant Number? " + isAbundant(number, factors));
        System.out.println("Is Deficient Number? " + isDeficient(number, factors));
        System.out.println("Is Strong Number? " + isStrong(number));

        sc.close();
    }
}