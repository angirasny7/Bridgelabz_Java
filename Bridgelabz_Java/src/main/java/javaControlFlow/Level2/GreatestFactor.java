package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Finds the greatest factor of a number other than itself.
 */

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer greater than 1: ");
        int number = input.nextInt();

        if (number > 1) {
            int greatestFactor = 1;

            for (int i = number / 2; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }

            System.out.println("Greatest factor other than itself: "
                    + greatestFactor);
        } else {
            System.out.println("Please enter an integer greater than 1.");
        }

        input.close();
    }
}
