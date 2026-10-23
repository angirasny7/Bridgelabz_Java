
/*
 * Problem 1: Product Inventory
 * Create a Product class with instance variables productName and price,
 * and a class variable totalProducts shared among all products.
 * Add an instance method to display product details and a class method
 * to display the total number of products created.
 */

package Constructor.Level2;

// Class to represent a Product
class Product {

    // Instance variables: separate for each object
    String productName;
    double price;

    // Class variable: shared among all Product objects
    static int totalProducts = 0;

    // Constructor to initialize product details
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;

        // Increment the count whenever a product is created
        totalProducts++;
    }

    // Instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.printf("Price: %.2f%n", price);
    }

    // Class method to display the total number of products
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

// Main class
public class ProductInventory {

    public static void main(String[] args) {

        // Create Product objects
        Product product1 = new Product("Laptop", 55000.0);
        Product product2 = new Product("Mouse", 800.0);
        Product product3 = new Product("Keyboard", 1500.0);

        // Display details of each product
        System.out.println("----- Product 1 -----");
        product1.displayProductDetails();

        System.out.println("\n----- Product 2 -----");
        product2.displayProductDetails();

        System.out.println("\n----- Product 3 -----");
        product3.displayProductDetails();

        // Call the class method using the class name
        System.out.println();
        Product.displayTotalProducts();
    }
}
