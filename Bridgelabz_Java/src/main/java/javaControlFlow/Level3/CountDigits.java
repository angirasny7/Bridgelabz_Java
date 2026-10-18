package javaControlFlow.Level3;

import java.util.Scanner;

/*
 * Counts the number of digits in an integer.
 */

public class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        int count = 0;
        int remainingNumber = Math.abs(number);

        // Count digits by removing the last digit each time
        while (remainingNumber != 0) {
            remainingNumber /= 10;
            count++;
        }

        if (number == 0) {
            count = 1;
        }

        System.out.println("Number of digits: " + count);

        input.close();
    }
}
