package javaControlFlow.Level1;

import java.util.Scanner;

/*
 * Calculates a 5% bonus for employees with more than 5 years of service.
 */

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();

        double bonus = 0.0;

        // Calculate bonus if service exceeds 5 years
        if (yearsOfService > 5) {
            bonus = salary * 0.05;
        }

        System.out.printf("Bonus amount: %.2f%n", bonus);

        input.close();
    }
}
