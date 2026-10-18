package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Question 8: Counts down from the given number to 1 for a rocket launch.
 */

public class RocketCountdown {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the starting number from the user
        System.out.print("Enter the countdown number: ");
        int counter = input.nextInt();

        // Print the countdown until 1
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Rocket launched!");

        input.close();
    }
}
