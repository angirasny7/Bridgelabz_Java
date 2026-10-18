package javaControlFlow.Level2;

import java.util.Scanner;

/*
 * Checks whether a valid Gregorian calendar year is a leap year.
 */

public class LeapYearLogical {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("The year must be 1582 or later.");
        } else if (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
