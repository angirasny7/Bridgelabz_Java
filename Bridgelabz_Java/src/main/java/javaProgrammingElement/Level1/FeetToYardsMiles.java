package javaProgrammingElement.Level1;

import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Convert feet to yards
        double distanceInYards = distanceInFeet / 3;

        // Convert yards to miles
        double distanceInMiles = distanceInYards / 1760;

        // Display the results
        System.out.printf(
                "The distance in feet is %.2f, in yards is %.2f, and in miles is %.6f%n",
                distanceInFeet, distanceInYards, distanceInMiles
        );

        input.close();
    }
}

