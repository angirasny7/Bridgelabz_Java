package Arrays.Level2;

import java.util.Scanner;

/*
 * Calculates the BMI of multiple people and displays
 * their height, weight, BMI, and weight status.
 */

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of people
        System.out.print("Enter the number of people: ");
        int numberOfPeople = input.nextInt();

        if (numberOfPeople <= 0) {
            System.out.println("Error: Number of people must be positive.");
            input.close();
            return;
        }

        // Create arrays to store each person's details
        double[] weights = new double[numberOfPeople];
        double[] heights = new double[numberOfPeople];
        double[] bmi = new double[numberOfPeople];
        String[] weightStatus = new String[numberOfPeople];

        // Get the weight and height of each person
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            weights[i] = input.nextDouble();

            while (weights[i] <= 0) {
                System.out.print("Invalid weight. Enter a positive weight: ");
                weights[i] = input.nextDouble();
            }

            System.out.print("Enter height in cm: ");
            heights[i] = input.nextDouble();

            while (heights[i] <= 0) {
                System.out.print("Invalid height. Enter a positive height: ");
                heights[i] = input.nextDouble();
            }
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPeople; i++) {
            double heightInMetres = heights[i] / 100.0;

            bmi[i] = weights[i] / (heightInMetres * heightInMetres);

            if (bmi[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display each person's details
        System.out.println("\nBMI Report");
        System.out.printf("%-10s %-15s %-15s %-12s %-15s%n",
                "Person", "Weight (kg)", "Height (cm)", "BMI", "Status");

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.printf("%-10d %-15.2f %-15.2f %-12.2f %-15s%n",
                    i + 1, weights[i], heights[i], bmi[i], weightStatus[i]);
        }

        input.close();
    }
}