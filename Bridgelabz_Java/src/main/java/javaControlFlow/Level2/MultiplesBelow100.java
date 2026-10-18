package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Prints all positive multiples of a number below 100.
 */

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0 && number < 100) {
            for (int i = 99; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                    continue;
                }
            }
        } else {
            System.out.println("Please enter a number between 1 and 99.");
        }

        input.close();
    }
}
