package Arrays.Level2;

import java.util.Scanner;

/*
 * Calculates employee bonuses based on years of service
 * and displays the total bonus and salary amounts.
 */

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create arrays to store salaries and years of service
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];

        // Initialize variables to store total amounts
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Accept salary and years of service for each employee
        for (int i = 0; i < salary.length; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter salary: ");
            salary[i] = input.nextDouble();

            while (salary[i] < 0) {
                System.out.print("Invalid salary. Enter a non-negative salary: ");
                salary[i] = input.nextDouble();
            }

            System.out.print("Enter years of service: ");
            yearsOfService[i] = input.nextDouble();

            while (yearsOfService[i] < 0) {
                System.out.print("Invalid service years. Enter a non-negative value: ");
                yearsOfService[i] = input.nextDouble();
            }
        }

        // Calculate bonuses and new salaries
        for (int i = 0; i < salary.length; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            double newSalary = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary;

            System.out.printf(
                    "Employee %d: Bonus = %.2f, New Salary = %.2f%n",
                    i + 1, bonus[i], newSalary
            );
        }

        // Display the totals
        System.out.printf("%nTotal bonus payout: %.2f%n", totalBonus);
        System.out.printf("Total old salary: %.2f%n", totalOldSalary);
        System.out.printf("Total new salary: %.2f%n", totalNewSalary);

        input.close();
    }
}