package javaProgrammingElement.Level2;

import java.util.Scanner;

public class PoundsToKilograms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weightInPounds = input.nextDouble();

        double weightInKg = weightInPounds / 2.2;

        System.out.printf(
                "The weight of the person in pounds is %.2f and in kg is %.2f.%n",
                weightInPounds, weightInKg
        );

        input.close();
    }
}

