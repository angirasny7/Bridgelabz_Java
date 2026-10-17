package javaProgrammingElement.Level2;

import java.util.Scanner;

public class TravelComputationInput {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take travel details as input
        System.out.print("Enter the traveler's name: ");
        String name = input.nextLine();

        System.out.print("Enter the starting city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the intermediate city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter the destination city: ");
        String toCity = input.nextLine();

        // Take distances in miles
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double distanceFromToVia = input.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double distanceViaToFinalCity = input.nextDouble();

        // Take travel times in hours and minutes
        System.out.print("Enter hours for first journey: ");
        int hoursFromToVia = input.nextInt();

        System.out.print("Enter minutes for first journey: ");
        int minutesFromToVia = input.nextInt();

        System.out.print("Enter hours for second journey: ");
        int hoursViaToFinalCity = input.nextInt();

        System.out.print("Enter minutes for second journey: ");
        int minutesViaToFinalCity = input.nextInt();

        // Convert both journey times into minutes
        int timeFromToVia = hoursFromToVia * 60 + minutesFromToVia;
        int timeViaToFinalCity =
                hoursViaToFinalCity * 60 + minutesViaToFinalCity;

        // Calculate total distance and total time
        double totalDistance =
                distanceFromToVia + distanceViaToFinalCity;

        int totalTime = timeFromToVia + timeViaToFinalCity;

        // Convert total time into hours and remaining minutes
        int totalHours = totalTime / 60;
        int remainingMinutes = totalTime % 60;

        // Display travel details
        System.out.printf(
                "%n%s travels from %s to %s via %s.%n",
                name, fromCity, toCity, viaCity
        );

        System.out.printf("Total distance: %.2f miles%n", totalDistance);
        System.out.printf(
                "Total travel time: %d hours and %d minutes%n",
                totalHours, remainingMinutes
        );

        input.close();
    }
}

