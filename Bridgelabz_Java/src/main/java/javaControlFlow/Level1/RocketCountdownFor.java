package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Question 9: Counts down from the given number to 1 using a for loop.
 */

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the starting number from the user
        System.out.print("Enter the countdown number: ");
        int counter = input.nextInt();

        // Print the countdown from the starting number to 1
        for (; counter >= 1; counter--) {
            System.out.println(counter);
        }

        System.out.println("Rocket launched!");

        input.close();
    }
}
