package Methods.Level3;

import java.util.Scanner;

public class LineCalculator {

    // Calculate Euclidean distance between two points
    public static double calculateDistance(double x1, double y1,
                                           double x2, double y2) {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) +
                        Math.pow(y2 - y1, 2)
        );
    }

    // Calculate slope and y-intercept
    public static double[] findLineEquation(double x1, double y1,
                                            double x2, double y2) {
        if (x1 == x2) {
            return new double[]{Double.NaN, Double.NaN};
        }

        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;

        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);

        System.out.printf("Euclidean Distance: %.2f%n", distance);

        double[] equation = findLineEquation(x1, y1, x2, y2);

        if (Double.isNaN(equation[0])) {
            System.out.println("The line is vertical: x = " + x1);
        } else {
            System.out.printf("Slope (m): %.2f%n", equation[0]);
            System.out.printf("Y-intercept (b): %.2f%n", equation[1]);
            System.out.printf("Equation of the line: y = %.2fx + %.2f%n",
                    equation[0], equation[1]);
        }

        sc.close();
    }
}