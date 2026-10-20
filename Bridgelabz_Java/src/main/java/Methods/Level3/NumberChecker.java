package Methods.Level3;

import java.util.Scanner;

/*
 * Counts the digits of a number, stores its digits in an array,
 * checks whether it is a Duck or Armstrong number, and finds
 * the largest, second largest, smallest, and second smallest digits.
 */

public class NumberChecker {

    // Counts the number of digits in a number.
    public static int countDigits(int number) {
        int count = 0;

        do {
            count++;
            number /= 10;
        } while (number != 0);

        return count;
    }

    // Stores the digits of a number in an array from left to right.
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];

        // Extract digits from right to left and store them in reverse order.
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Checks whether a number is a Duck number using its digits.
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
    }

    // Checks whether a number is an Armstrong number.
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int digit : digits) {
            sum += (int) Math.pow(digit, power);
        }

        return sum == number;
    }

    // Finds the largest and second largest distinct digits.
    public static int[] findLargestTwo(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    // Finds the smallest and second smallest distinct digits.
    public static int[] findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take a non-negative number as input.
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

        // Check Duck and Armstrong numbers.
        System.out.println("Is Duck number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong number: "
                + isArmstrongNumber(number, digits));

        // Find the largest and second largest digits.
        int[] largestTwo = findLargestTwo(digits);

        System.out.println("Largest digit: " + largestTwo[0]);

        if (largestTwo[1] == Integer.MIN_VALUE) {
            System.out.println("Second largest distinct digit: Not available");
        } else {
            System.out.println("Second largest distinct digit: " + largestTwo[1]);
        }

        // Find the smallest and second smallest digits.
        int[] smallestTwo = findSmallestTwo(digits);

        System.out.println("Smallest digit: " + smallestTwo[0]);

        if (smallestTwo[1] == Integer.MAX_VALUE) {
            System.out.println("Second smallest distinct digit: Not available");
        } else {
            System.out.println("Second smallest distinct digit: " + smallestTwo[1]);
        }

        input.close();
    }
}