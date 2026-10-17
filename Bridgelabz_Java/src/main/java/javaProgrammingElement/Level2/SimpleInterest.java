package javaProgrammingElement.Level2;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take principal amount as input
        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        // Take rate of interest as input
        System.out.print("Enter the rate of interest (%): ");
        double rate = input.nextDouble();

        // Take time period as input
        System.out.print("Enter the time in years: ");
        double time = input.nextDouble();

        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;

        // Display the result
        System.out.printf(
                "The Simple Interest is INR %.2f for Principal INR %.2f, Rate of Interest %.2f%% and Time %.2f years.%n",
                simpleInterest, principal, rate, time
        );

        input.close();
    }
}

