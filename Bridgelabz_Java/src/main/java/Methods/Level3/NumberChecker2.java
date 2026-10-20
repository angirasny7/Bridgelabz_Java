package Methods.Level3;

import java.util.Scanner;

/*
 * Counts the digits of a number, calculates the sum and sum of squares
 * of its digits, checks whether it is a Harshad number, and finds
 * the frequency of each digit.
 */

public class NumberChecker2 {

    // Counts the number of digits in a number.
    public static int countDigits(int number) {
        int count = 0;

        do {
            count++;
            number /= 10;
        } while (number != 0);

        return count;
    }

    // Stores the digits of a number in an array in their original order.
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Calculates the sum of the digits.
    public static int sumOfDigits(int[] digits) {
        int sum = 0;

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    // Calculates the sum of the squares of the digits.
    public static double sumOfSquares(int[] digits) {
        double sum = 0;

        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }

        return sum;
    }

    // Checks whether the number is a Harshad number.
    public static boolean isHarshadNumber(int number, int[] digits) {
        if (number <= 0) {
            return false;
        }

        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Stores each digit and its frequency in a two-dimensional array.
    public static int[][] findDigitFrequency(int[] digits) {
        int[] frequency = new int[10];

        // Count the occurrences of each digit.
        for (int digit : digits) {
            frequency[digit]++;
        }

        // Store the digit in column 0 and its frequency in column 1.
        int[][] result = new int[10][2];

        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = frequency[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take a non-negative integer as input.
        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Invalid input! Please enter a non-negative integer.");
            input.close();
            return;
        }

        // Count and store the digits.
        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.println("Number of digits: " + count);

        System.out.print("Digits array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        // Calculate the sum and sum of squares.
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));

        // Check whether the number is a Harshad number.
        System.out.println("Is Harshad number: "
                + isHarshadNumber(number, digits));

        // Calculate and display digit frequencies.
        int[][] frequency = findDigitFrequency(digits);

        System.out.println("\nDigit Frequency:");
        System.out.printf("%-10s %s%n", "Digit", "Frequency");

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.printf("%-10d %d%n",
                        frequency[i][0], frequency[i][1]);
            }
        }

        input.close();
    }
}