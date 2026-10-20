package Methods.Level3;

import java.util.Random;

public class EmployeeBonus {

    // Generate random salary and years of service for 10 employees
    public static double[][] generateEmployeeData(int count) {
        double[][] employees = new double[count][2];

        for (int i = 0; i < count; i++) {
            employees[i][0] = 20000 + Math.random() * 80001;
            employees[i][1] = (int) (Math.random() * 11);
        }

        return employees;
    }

    // Calculate bonus and new salary
    public static double[][] calculateBonusAndSalary(double[][] employees) {
        double[][] result = new double[employees.length][2];

        for (int i = 0; i < employees.length; i++) {
            double salary = employees[i][0];
            int years = (int) employees[i][1];

            double bonusRate = years > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;

            result[i][0] = newSalary;
            result[i][1] = bonus;
        }

        return result;
    }

    // Calculate total bonus and total new salary
    public static double[] calculateTotals(double[][] result) {
        double totalBonus = 0;
        double totalNewSalary = 0;

        for (double[] employee : result) {
            totalBonus += employee[1];
            totalNewSalary += employee[0];
        }

        return new double[]{totalBonus, totalNewSalary};
    }

    // Display employee details
    public static void displayResults(double[][] employees, double[][] result) {
        System.out.printf("%-12s %-12s %-12s %-15s %-15s%n",
                "Employee", "Salary", "Years", "Bonus", "New Salary");

        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%-12d %-12.2f %-12.0f %-15.2f %-15.2f%n",
                    i + 1,
                    employees[i][0],
                    employees[i][1],
                    result[i][1],
                    result[i][0]);
        }
    }

    public static void main(String[] args) {
        int count = 10;

        double[][] employees = generateEmployeeData(count);
        double[][] result = calculateBonusAndSalary(employees);
        double[] totals = calculateTotals(result);

        displayResults(employees, result);

        System.out.printf("%nTotal Bonus Amount: %.2f%n", totals[0]);
        System.out.printf("Total New Salary Amount: %.2f%n", totals[1]);
    }
}