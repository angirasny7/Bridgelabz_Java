
package Strings.Extras.Extras2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Problem:
 * Display the current date in three different formats:
 * 1. dd/MM/yyyy
 * 2. yyyy-MM-dd
 * 3. EEE, MMM dd, yyyy
 */

public class DateFormatting {

    public static void main(String[] args) {

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Create formatters for three different date formats
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display the date in all three formats
        System.out.println("Current Date in Different Formats");
        System.out.println("---------------------------------");

        System.out.println("Format 1 (dd/MM/yyyy): "
                + currentDate.format(format1));

        System.out.println("Format 2 (yyyy-MM-dd): "
                + currentDate.format(format2));

        System.out.println("Format 3 (EEE, MMM dd, yyyy): "
                + currentDate.format(format3));
    }
}
