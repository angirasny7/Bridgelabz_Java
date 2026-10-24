
/*
 * Sample Program 4: Shopping Cart System
 * 1. Use a static variable discount shared by all products.
 * 2. Use a static method updateDiscount() to modify the discount percentage.
 * 3. Use this to initialize productName, price, and quantity.
 * 4. Use a final variable productID that cannot be reassigned.
 * 5. Use instanceof to validate an object's type before processing details.
 */

package ThisStaticFinal;

// Class to represent a Product
class Product {

    // Static variable shared by all products (discount percentage)
    static double discount = 10.0;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Final variable: product ID cannot be reassigned
    final int productID;

    // Constructor to initialize product details
    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method to update the shared discount percentage
    static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
            System.out.println("Discount updated successfully.");
        } else {
            System.out.println("Invalid discount! Enter a value from 0 to 100.");
        }
    }

    // Method to calculate the total price after discount
    double calculateTotalPrice() {
        double total = price * quantity;
        return total - (total * discount / 100);
    }

    // Instance method to display product details
    void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.printf("Price per Item: %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.printf("Total Price after Discount: %.2f%n",
                calculateTotalPrice());
    }
}

// Main class
public class ShoppingCartSystem {

    public static void main(String[] args) {

        // Create Product objects
        Product product1 = new Product("Laptop", 50000.0, 1, 101);
        Product product2 = new Product("Headphones", 2000.0, 2, 102);

        // Store a Product object in an Object reference
        Object obj = product1;

        // Validate the object type before processing its details
        if (obj instanceof Product) {
            System.out.println("Object is a Product.");

            // Typecast Object to Product
            Product product = (Product) obj;

            System.out.println("\n----- Product 1 Details -----");
            product.displayDetails();
        } else {
            System.out.println("Invalid object type.");
        }

        // Display the second product
        System.out.println("\n----- Product 2 Details -----");
        product2.displayDetails();

        // Update the shared discount for all products
        System.out.println("\nUpdating Discount...");
        Product.updateDiscount(20.0);

        // Display both products with the updated discount
        System.out.println("\n----- Updated Product 1 -----");
        product1.displayDetails();

        System.out.println("\n----- Updated Product 2 -----");
        product2.displayDetails();
    }
}
