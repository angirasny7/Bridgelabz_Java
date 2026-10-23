
/*
 * Question: Simulate a Shopping Cart
 * Create a CartItem class with attributes itemName, price, and quantity.
 * Add methods to add an item, remove an item, and display the total cost.
 */

package ClassesAndObjects.Level2;

import java.util.Scanner;

// Class to represent an item in the shopping cart
class CartItem {

    // Attributes to store item details
    String itemName;
    double price;
    int quantity;

    // Method to add items to the cart
    void addItem(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Item added to cart successfully.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    // Method to remove items from the cart
    void removeItem(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid quantity.");
        } else if (amount <= quantity) {
            quantity -= amount;
            System.out.println("Item removed from cart successfully.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    // Method to calculate and display the total cost
    void displayTotalCost() {
        double totalCost = price * quantity;

        System.out.println("\n----- Shopping Cart Details -----");
        System.out.println("Item Name: " + itemName);
        System.out.printf("Price per Item: %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}

// Main class
public class ShoppingCart {

    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the CartItem class
        CartItem item = new CartItem();

        // Input item details
        System.out.print("Enter item name: ");
        item.itemName = input.nextLine();

        System.out.print("Enter price per item: ");
        item.price = input.nextDouble();

        System.out.print("Enter initial quantity: ");
        item.quantity = input.nextInt();

        // Add more items to the cart
        System.out.print("Enter quantity to add: ");
        int addQuantity = input.nextInt();
        item.addItem(addQuantity);

        // Remove items from the cart
        System.out.print("Enter quantity to remove: ");
        int removeQuantity = input.nextInt();
        item.removeItem(removeQuantity);

        // Display the final cart total
        item.displayTotalCost();

        // Close the Scanner
        input.close();
    }
}
