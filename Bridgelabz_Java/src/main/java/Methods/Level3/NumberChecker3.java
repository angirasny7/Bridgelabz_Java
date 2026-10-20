package Methods.Level3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker3 {

    // Count the digits in a number
    public static int countDigits(int number) {
        int count = 0;

        do {
            count++;
            number /= 10;
        } while (number != 0);

        return count;
    }

    // Store the digits of a number in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    // Compare two arrays for equality
    public static boolean compareArrays(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    // Check whether a number is a palindrome
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    // Check whether a number is a duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
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

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);
        int[] reversed = reverseArray(digits);

        System.out.println("Number of digits: " + count);
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Reversed digits array: " + Arrays.toString(reversed));

        System.out.println("Are the arrays equal? "
                + compareArrays(digits, reversed));

        System.out.println("Is the number a palindrome? "
                + isPalindrome(digits));

        System.out.println("Is the number a duck number? "
                + isDuckNumber(digits));

        sc.close();
    }
}