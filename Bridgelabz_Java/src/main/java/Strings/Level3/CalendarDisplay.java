
package Strings.Level3;

import java.util.Scanner;

/*
 * Problem:
 * Display the calendar for a given month and year.
 * Use the Gregorian calendar algorithm to find the
 * starting day and display the dates in tabular format.
 */

public class CalendarDisplay {

    // Array containing month names
    static String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    // Array containing days in each month
    static int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    // Method to get the month name
    public static String getMonthName(int month) {
        return months[month - 1];
    }

    // Method to check whether a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }

    // Method to get the number of days in a month
    public static int getDaysInMonth(int month, int year) {

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return daysInMonth[month - 1];
    }

    // Method to calculate the first day of the month
    // Returns 0 for Sunday, 1 for Monday, ..., 6 for Saturday
    public static int getStartDay(int month, int year) {

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;

        return d0;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {

        int startDay = getStartDay(month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("\n     " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop: print indentation before day 1
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Second loop: print all dates
        for (int day = 1; day <= totalDays; day++) {

            System.out.printf("%3d ", day);

            // Move to a new line after Saturday
            if ((startDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year.");
        } else {
            displayCalendar(month, year);
        }

        sc.close();
    }
}
