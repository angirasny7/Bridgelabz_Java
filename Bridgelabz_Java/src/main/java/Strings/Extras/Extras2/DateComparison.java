
package Strings.Extras.Extras2;

import java.time.LocalDate;
import java.util.Scanner;

/*
 * Problem:
 * Take two dates as input and compare them to check
 * whether the first date is before, after, or equal
 * to the second date.
 */

public class DateComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the first date as input
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        // Take the second date as input
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Compare the two dates
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is after " + date2);
        } else if (date1.isEqual(date2)) {
            System.out.println(date1 + " is equal to " + date2);
        }

        sc.close();
    }
}
