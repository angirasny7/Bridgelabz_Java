package javaProgrammingElement.Level1;

import java.util.Scanner;
public class SquareSide {
    public static void main(String[] args){
        //Create Scanner object to take input from user
        Scanner input = new Scanner(System.in);

        //Take perimeter as input
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        //Calculate the side of the square
        double side = perimeter / 4;

        //Display the result
        System.out.printf("The length of the side is %.2f whose perimeter is %.2f%n", side, perimeter);

        input.close();
    }
}
