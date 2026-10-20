package Methods.Level2;

import java.util.Scanner;

/*
 * Finds the roots of a quadratic equation ax^2 + bx + c = 0
 * using the discriminant, Math.pow(), and Math.sqrt().
 */

public class Quadratic {

    // Calculates and returns the roots of a quadratic equation.
    public static double[] findRoots(double a, double b, double c) {

        // A quadratic equation requires a to be non-zero.
        if (a == 0) {
            return new double[0];
        }

        // Calculate the discriminant.
        double delta = Math.pow(b, 2) - (4 * a * c);

        // If delta is positive, calculate two distinct real roots.
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);

            return new double[]{root1, root2};
        }

        // If delta is zero, calculate the single repeated real root.
        else if (delta == 0) {
            double root = -b / (2 * a);

            return new double[]{root};
        }

        // If delta is negative, there are no real roots.
        else {
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the coefficients as input.
        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        // Find the roots using the method.
        double[] roots = findRoots(a, b, c);

        // Display the roots.
        if (a == 0) {
            System.out.println("Invalid input! A quadratic equation requires a != 0.");
        } else if (roots.length == 2) {
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("The equation has one repeated root: " + roots[0]);
        } else {
            System.out.println("The equation has no real roots.");
        }

        input.close();
    }
}