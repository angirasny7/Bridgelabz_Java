
/*
 * Question: Handle Mobile Phone Details
 * Create a MobilePhone class with attributes brand, model, and price.
 * Add a method to display all the details of the phone.
 */

package ClassesAndObjects.Level1;

import java.util.Scanner;

// Class to represent a Mobile Phone
class MobilePhone {

    // Attributes to store phone details
    String brand;
    String model;
    double price;

    // Method to display all phone details
    void displayDetails() {
        System.out.println("\nMobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

// Main class
public class DisplayMobilePhoneDetails {

    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Create an object of the MobilePhone class
        MobilePhone phone = new MobilePhone();

        // Input phone details
        System.out.print("Enter phone brand: ");
        phone.brand = input.nextLine();

        System.out.print("Enter phone model: ");
        phone.model = input.nextLine();

        System.out.print("Enter phone price: ");
        phone.price = input.nextDouble();

        // Call the method to display phone details
        phone.displayDetails();

        // Close the Scanner
        input.close();
    }
}
