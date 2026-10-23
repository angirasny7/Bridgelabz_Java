package ClassesAndObjects.Level1;
import java.util.Scanner;

/*
 * Question: Track Inventory of Items
 * Create an Item class with attributes itemCode, itemName, and price.
 * Add a method to display item details and calculate the
 * total cost for a given quantity.
 */

class Item{
    int itemCode;
    String itemName;
    double price;

    void displayDetails(){
        System.out.println("Item Details: ");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: " + price);
    }
    double calculateTotalCost(int quantity){
        return price*quantity;
    }

}
public class ItemInventory {
    public static void main(String[] args){
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the Item class
        Item item = new Item();

        // Input item details
        System.out.print("Enter item code: ");
        item.itemCode = input.nextInt();
        input.nextLine(); // Consume the leftover newline

        System.out.print("Enter item name: ");
        item.itemName = input.nextLine();

        System.out.print("Enter price per item: ");
        item.price = input.nextDouble();

        // Input the quantity
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        // Display item details
        item.displayDetails();

        // Calculate and display the total cost
        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Cost: %.2f%n", totalCost);

        // Close the Scanner
        input.close();
    }
}
