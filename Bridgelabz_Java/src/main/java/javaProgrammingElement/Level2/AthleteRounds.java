package javaProgrammingElement.Level2;

import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take the three sides of the triangular park
        System.out.print("Enter side 1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        double side3 = input.nextDouble();

        // Calculate the perimeter of the park
        double perimeter = side1 + side2 + side3;

        // Convert 5 km to meters
        double totalDistance = 5000;

        // Calculate the number of rounds
        double rounds = totalDistance / perimeter;

        // Display the result
        System.out.printf(
                "The total number of rounds the athlete will run is %.2f to complete 5 km.%n",
                rounds
        );

        input.close();
    }
}

