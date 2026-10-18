package javaControlFlow.Level3;

/*
 * Finds the day of the week for a given Gregorian calendar date.
 */

public class DayOfWeek {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);

        // Calculate the Gregorian calendar values
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;

        String[] days = {
                "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"
        };

        System.out.println("Day of the week: " + days[d]);
    }
}
