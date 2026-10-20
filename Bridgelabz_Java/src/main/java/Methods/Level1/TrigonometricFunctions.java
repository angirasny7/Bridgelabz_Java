package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates sine, cosine, and tangent for an angle in degrees.
 */
public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        double[] results = calculateTrigonometricFunctions(angle);

        System.out.printf("Sine of %.2f degrees: %.4f%n", angle, results[0]);
        System.out.printf("Cosine of %.2f degrees: %.4f%n", angle, results[1]);

        if (Math.abs(Math.cos(Math.toRadians(angle))) < 1e-10) {
            System.out.println("Tangent is undefined.");
        } else {
            System.out.printf("Tangent of %.2f degrees: %.4f%n", angle, results[2]);
        }

        input.close();
    }
}