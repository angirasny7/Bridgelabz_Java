package javaProgrammingElement.Level1;

import java.util.Scanner;
public class ConvertHeights {
    public static void main(String[] args){

        //Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        //Take height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double heightCm  = input.nextDouble();

        //Convert centimeters into inches
        double totalInches = heightCm / 2.54;

        //Covert total inches to feet and remaining inches
        int feet = (int)(totalInches/12);
        double inches = totalInches - (feet*12);

        //Display the result
        System.out.printf("Yout Height in cm is %.2f while in feet is %d and inches is %.2f%n", heightCm, feet, inches);
    }
}
