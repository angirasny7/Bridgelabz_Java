package javaProgrammingElement.Level1;

import java.util.Scanner;

public class PurchasePrice {
    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Take unit price as input
        System.out.print("Enter the unit price in INR: ");
        double unitPrice = input.nextDouble();

        // Take quantity as input
        System.out.print("Enter the quantity: ");
        int quantity = input.nextInt();

        // Calculate total purchase price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.printf(
                "The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f%n",
                totalPrice, quantity, unitPrice
        );

        input.close();
    }
}

