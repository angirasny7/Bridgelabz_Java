package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Calculates BMI and displays the corresponding weight status.
 */

public class CalculateBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        if (weight <= 0 || heightCm <= 0) {
            System.out.println("Weight and height must be positive.");
        } else {
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            String status;

            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            System.out.printf("BMI: %.2f%n", bmi);
            System.out.println("Status: " + status);
        }

        input.close();
    }
}
