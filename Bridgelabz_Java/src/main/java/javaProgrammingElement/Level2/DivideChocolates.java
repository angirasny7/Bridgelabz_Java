package javaProgrammingElement.Level2;

import java.util.Scanner;

public class DivideChocolates {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take number of chocolates and children as input
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Calculate chocolates per child
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;

        // Calculate remaining chocolates
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        // Display the results
        System.out.println(
                "The number of chocolates each child gets is " +
                        chocolatesPerChild +
                        " and the number of remaining chocolates are " +
                        remainingChocolates
        );

        input.close();
    }
}

