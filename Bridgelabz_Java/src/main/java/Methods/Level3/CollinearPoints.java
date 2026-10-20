package Methods.Level3;

import java.util.Scanner;

public class CollinearPoints {

    // Check collinearity using slopes
    public static boolean areCollinearUsingSlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double slopeAB = (y2 - y1) * (x3 - x2);
        double slopeBC = (y3 - y2) * (x2 - x1);

        return slopeAB == slopeBC;
    }

    // Check collinearity using the area of a triangle
    public static boolean areCollinearUsingArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double area = 0.5 * Math.abs(
                x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
        );

        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.print("Enter x3 and y3: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        boolean slopeResult = areCollinearUsingSlope(
                x1, y1, x2, y2, x3, y3);

        boolean areaResult = areCollinearUsingArea(
                x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear using slope method: " + slopeResult);
        System.out.println("Collinear using area method: " + areaResult);

        sc.close();
    }
}