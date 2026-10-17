package javaProgrammingElement.Level2;


import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take two numbers as input
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Swap the numbers using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Display the swapped numbers
        System.out.println(
                "The swapped numbers are " + number1 + " and " + number2
        );

        input.close();
    }
}

