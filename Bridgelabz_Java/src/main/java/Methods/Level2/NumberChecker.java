package Methods.Level2;

import java.util.Scanner;

/*
 * Checks whether five numbers are positive or negative.
 * For positive numbers, checks whether they are even or odd.
 * Finally, compares the first and last array elements.
 */

public class NumberChecker {

    // Checks whether a number is positive.
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Checks whether a number is even.
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Compares two numbers: returns 1, 0, or -1.
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create an array to store five numbers.
        int[] numbers = new int[5];

        // Take five numbers as input.
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Check whether each number is positive, negative, or zero.
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (isPositive(number)) {
                if (isEven(number)) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            } else if (number < 0) {
                System.out.println(number + " is negative.");
            } else {
                System.out.println(number + " is zero.");
            }
        }

        // Compare the first and last elements of the array.
        int result = compare(numbers[0], numbers[numbers.length - 1]);

        if (result == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (result == 0) {
            System.out.println("First element is equal to the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        input.close();
    }
}