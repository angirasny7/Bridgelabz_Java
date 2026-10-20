package Methods.Level1;

import java.util.Scanner;

/*
 * Calculates wind chill temperature using temperature and wind speed.
 */
public class WindChill {

    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature)
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = input.nextDouble();

        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = input.nextDouble();

        if (temperature > 50 || windSpeed <= 3 || windSpeed > 120) {
            System.out.println("Invalid input. Temperature must be at most 50°F, and wind speed must be greater than 3 mph and at most 120 mph.");
        } else {
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("Wind chill temperature: %.2f°F%n", windChill);
        }

        input.close();
    }
}