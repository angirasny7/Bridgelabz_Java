package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Prints FizzBuzz for numbers from 0 to the given positive integer.
 */

public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            int i = 0;

            while (i <= number) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }

                i++;
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        input.close();
    }
}
