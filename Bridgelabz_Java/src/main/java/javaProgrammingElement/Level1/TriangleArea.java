package javaProgrammingElement.Level1;

import java.util.Scanner;
public class TriangleArea {
    public static void main(String[] args){
        //Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        //Take base and height in inches
        System.out.print("Enter the base in inches: ");
        double base = input.nextDouble();

        System.out.print("Enter the height in inches: ");
        double height = input.nextDouble();

        //Calculate area in square inches
        double areaInSquareInches = 0.5 * base * height;

        //Calculate square inches to square centimeters
        double areaInSquareCm = areaInSquareInches * 2.54 * 2.54;

        //Display the results
        System.out.printf("The area of triangle is %.2f square inches and %.2f " +
                "square centimeters.%n", areaInSquareInches, areaInSquareCm);
    }
}
