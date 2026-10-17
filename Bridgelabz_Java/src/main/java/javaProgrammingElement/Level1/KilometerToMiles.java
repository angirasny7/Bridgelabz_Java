package javaProgrammingElement.Level1;

import java.util.Scanner;
public class KilometerToMiles {
    public static void main(String[] args){

        //Create Scanner object to take the user input
        Scanner input = new Scanner(System.in);

        //Take distance in kilometers as input
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();

        //Convert kilometers to miles
        double miles = km / 1.6;

        //Display the result
        System.out.printf("The Total miles is %.2f mile for the given %.2f km%n", miles, km);

    }
}

