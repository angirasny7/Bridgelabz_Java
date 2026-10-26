package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 6: Online Food Delivery System
 *
 * Create an abstract FoodItem class, VegItem and NonVegItem
 * subclasses, and a Discountable interface.
 *
 * Use encapsulation to protect food details, abstraction for
 * price calculation, inheritance for food categories, and
 * polymorphism to process different items in one order.
 */

// Interface defining discount-related behavior
interface Discountable {

    // Return the price after applying a discount
    double applyDiscount();

    // Return information about the discount
    String getDiscountDetails();
}

// Abstract class representing a general food item
abstract class FoodItem implements Discountable {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Item name cannot be empty."
            );
        }
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException(
                    "Price must be non-negative and finite."
            );
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive."
            );
        }
        this.quantity = quantity;
    }

    // Each subclass calculates its own total price
    public abstract double calculateTotalPrice();

    // Display common food details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.printf("Price per Item: Rs. %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Subtotal: Rs. %.2f%n",
                calculateTotalPrice());
        System.out.printf("Price After Discount: Rs. %.2f%n",
                applyDiscount());
        System.out.println(getDiscountDetails());
    }
}

// Vegetarian food item
class VegItem extends FoodItem {

    private static final double DISCOUNT_RATE = 0.10;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Vegetarian items have no additional preparation charge
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Apply a 10% discount to the subtotal
    @Override
    public double applyDiscount() {
        return calculateTotalPrice()
                * (1 - DISCOUNT_RATE);
    }

    @Override
    public String getDiscountDetails() {
        return "Vegetarian discount: 10%";
    }
}

// Non-vegetarian food item
class NonVegItem extends FoodItem {

    private static final double EXTRA_CHARGE = 30.0;
    private static final double DISCOUNT_RATE = 0.05;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Add an extra preparation charge for each item
    @Override
    public double calculateTotalPrice() {
        return (getPrice() + EXTRA_CHARGE) * getQuantity();
    }

    // Apply a 5% discount to the subtotal including extra charges
    @Override
    public double applyDiscount() {
        return calculateTotalPrice()
                * (1 - DISCOUNT_RATE);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-vegetarian discount: 5%";
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    // Process a list containing different types of food
    public static void processOrder(List<FoodItem> items) {

        double orderTotal = 0;

        for (FoodItem item : items) {
            System.out.println("\n----------------------");

            // Polymorphism invokes the correct subclass methods
            item.getItemDetails();

            orderTotal += item.applyDiscount();
        }

        System.out.println("\n======================");
        System.out.printf("Final Order Total: Rs. %.2f%n",
                orderTotal);
    }

    public static void main(String[] args) {

        // Create different food items
        VegItem paneer = new VegItem(
                "Paneer Biryani", 200, 2
        );

        NonVegItem chicken = new NonVegItem(
                "Chicken Biryani", 250, 2
        );

        // Store both types in one order
        List<FoodItem> order = new ArrayList<>();

        order.add(paneer);
        order.add(chicken);

        // Process the complete order
        processOrder(order);
    }
}
