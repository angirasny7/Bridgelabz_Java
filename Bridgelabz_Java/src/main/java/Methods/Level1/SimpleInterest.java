package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates simple interest using a user-defined method.
 */

public class SimpleInterest {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter the time in years: ");
        double time = input.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        System.out.printf(
                "The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f years.%n",
                simpleInterest, principal, rate, time
        );

        input.close();
    }
}