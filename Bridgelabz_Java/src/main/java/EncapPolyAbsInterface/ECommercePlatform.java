package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 2: E-Commerce Platform
 *
 * Develop an e-commerce platform using an abstract Product class,
 * Electronics, Clothing, and Groceries subclasses, and a Taxable
 * interface.
 *
 * Protect product details using encapsulation, calculate discounts
 * through abstraction, and demonstrate polymorphism by processing
 * different products through Product references.
 */

// Interface for products that have applicable taxes
interface Taxable {

    // Calculate the tax amount
    double calculateTax();

    // Return information about the applicable tax
    String getTaxDetails();
}

// Abstract class representing a general product
abstract class Product {

    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        setProductId(productId);
        setName(name);
        setPrice(price);
    }

    // Getter and setter for productId
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive."
            );
        }
        this.productId = productId;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty."
            );
        }
        this.name = name;
    }

    // Getter and setter for price
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

    // Each product category defines its own discount
    public abstract double calculateDiscount();

    // Display common product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.printf("Price: Rs. %.2f%n", price);
        System.out.printf("Discount: Rs. %.2f%n",
                calculateDiscount());
    }
}

// Electronics product
class Electronics extends Product implements Taxable {

    private static final double DISCOUNT_RATE = 0.10;
    private static final double TAX_RATE = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Electronics receive a 10% discount
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    // Tax is calculated after applying the discount
    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics tax rate: 18%";
    }
}

// Clothing product
class Clothing extends Product implements Taxable {

    private static final double DISCOUNT_RATE = 0.20;
    private static final double TAX_RATE = 0.05;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Clothing receives a 20% discount
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: 5%";
    }
}

// Groceries product
class Groceries extends Product implements Taxable {

    private static final double DISCOUNT_RATE = 0.05;
    private static final double TAX_RATE = 0.03;

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Groceries receive a 5% discount
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Groceries tax rate: 3%";
    }
}

// Main class
public class ECommercePlatform {

    // Process any product without needing its specific subclass
    public static void calculateFinalPrice(Product product) {

        System.out.println("\n----------------------");

        product.displayDetails();

        // Taxable is implemented by all three product classes
        Taxable taxable = (Taxable) product;

        double tax = taxable.calculateTax();

        double finalPrice = product.getPrice()
                - product.calculateDiscount() + tax;

        System.out.printf("Tax: Rs. %.2f%n", tax);
        System.out.println(taxable.getTaxDetails());
        System.out.printf("Final Price: Rs. %.2f%n", finalPrice);
    }

    public static void main(String[] args) {

        // Create different product objects
        Electronics laptop = new Electronics(
                101, "Laptop", 50000
        );

        Clothing shirt = new Clothing(
                102, "Shirt", 2000
        );

        Groceries rice = new Groceries(
                103, "Rice", 1000
        );

        // Store all products using the parent class reference
        List<Product> products = new ArrayList<>();

        products.add(laptop);
        products.add(shirt);
        products.add(rice);

        // Polymorphism: each product uses its own discount and tax logic
        for (Product product : products) {
            calculateFinalPrice(product);
        }
    }
}
