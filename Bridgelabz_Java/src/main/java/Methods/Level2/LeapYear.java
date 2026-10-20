package Methods.Level2;
import java.util.Scanner;

/*
 * Checks whether a given year is a leap year
 * according to the Gregorian calendar.
 */

public class LeapYear {
    // Checks whether the given year is a leap year.
    public static boolean isLeapYear(int year){
        // The Gregorian calendar applies from the year 1582.
        if(year < 1582){
            return false;
        }
        // A leap year is divisible by 400, or divisible by 4 but not by 100.
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Take the year as input
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Validate the year and display the result.
        if (year < 1582) {
            System.out.println("Invalid year! Enter a year greater than or equal to 1582.");
        } else if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();

    }


}
