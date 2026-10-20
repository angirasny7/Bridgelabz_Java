package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates the number of rounds needed to complete a 5 km run.
 */
public class AthleteRunning {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000;

        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side of the triangular park (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter the second side of the triangular park (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter the third side of the triangular park (in meters): ");
        double side3 = input.nextDouble();

        if (side1 <= 0 || side2 <= 0 || side3 <= 0
                || side1 + side2 <= side3
                || side1 + side3 <= side2
                || side2 + side3 <= side1) {
            System.out.println("Invalid triangle sides.");
        } else {
            double rounds = calculateRounds(side1, side2, side3);
            System.out.printf("Number of rounds required: %.2f%n", rounds);
        }

        input.close();
    }
}