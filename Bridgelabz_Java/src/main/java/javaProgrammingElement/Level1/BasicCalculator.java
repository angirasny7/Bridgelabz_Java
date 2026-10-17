package javaProgrammingElement.Level1;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args){
        //Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        //Take two numbers as input
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        //Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication  = number1 * number2;
        double division = number1 / number2;

        //Display the results
        System.out.printf("The addition, subtraction, multiplication and division value of " +
                "2 numbers %.2f and %.2f is %.2f, %.2f, %.2f and %.2f%n ", number1, number2,
                addition, subtraction, multiplication, division);

        input.close();
    }
}
