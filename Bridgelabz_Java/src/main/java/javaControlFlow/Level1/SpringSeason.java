
package javaControlFlow.Level1;

/*
 * Question 7: Checks whether a given date falls in the spring season
 * (March 20 to June 20).
 */

public class SpringSeason {
    public static void main(String[] args) {

        // Read month and day from command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check whether the date falls within spring season
        if ((month == 3 && day >= 20 && day <= 31)
                || (month == 4 && day >= 1 && day <= 30)
                || (month == 5 && day >= 1 && day <= 31)
                || (month == 6 && day >= 1 && day <= 20)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
