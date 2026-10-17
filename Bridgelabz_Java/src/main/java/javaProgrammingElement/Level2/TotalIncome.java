package javaProgrammingElement.Level2;


import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take salary as input
        System.out.print("Enter salary in INR: ");
        double salary = input.nextDouble();

        // Take bonus as input
        System.out.print("Enter bonus in INR: ");
        double bonus = input.nextDouble();

        // Calculate total income
        double totalIncome = salary + bonus;

        // Display the result
        System.out.printf(
                "The salary is INR %.2f and bonus is INR %.2f. Hence Total Income is INR %.2f%n",
                salary, bonus, totalIncome
        );

        input.close();
    }
}

