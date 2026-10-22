
package Strings.Extras.Extras2;

import java.time.LocalDate;
import java.util.Scanner;

/*
 * Problem:
 * Take a date as input and perform the following operations:
 * 1. Add 7 days.
 * 2. Add 1 month.
 * 3. Add 2 years.
 * 4. Subtract 3 weeks from the final result.
 */

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take date input from the user
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        // Convert the input string into a LocalDate
        LocalDate date = LocalDate.parse(input);

        System.out.println("Original Date: " + date);

        // Add 7 days
        date = date.plusDays(7);
        System.out.println("After adding 7 days: " + date);

        // Add 1 month
        date = date.plusMonths(1);
        System.out.println("After adding 1 month: " + date);

        // Add 2 years
        date = date.plusYears(2);
        System.out.println("After adding 2 years: " + date);

        // Subtract 3 weeks from the result
        date = date.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + date);

        sc.close();
    }
}
