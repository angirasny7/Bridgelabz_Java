package Strings.Extras.Extras2;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
 * Problem:
 * Display the current time in different time zones:
 * GMT - Greenwich Mean Time
 * IST - Indian Standard Time
 * PST - Pacific Standard Time
 */

public class TimeZones {

    public static void main(String[] args) {

        // Define the time zones
        ZoneId gmtZone = ZoneId.of("GMT");
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        ZoneId pstZone = ZoneId.of("America/Los_Angeles");

        // Get the current time in each time zone
        ZonedDateTime gmtTime = ZonedDateTime.now(gmtZone);
        ZonedDateTime istTime = ZonedDateTime.now(istZone);
        ZonedDateTime pstTime = ZonedDateTime.now(pstZone);

        // Define the date and time format
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        // Display the current time
        System.out.println("Current Time in Different Time Zones");
        System.out.println("------------------------------------");

        System.out.println("GMT : " + gmtTime.format(formatter));
        System.out.println("IST : " + istTime.format(formatter));
        System.out.println("PST : " + pstTime.format(formatter));
    }
}