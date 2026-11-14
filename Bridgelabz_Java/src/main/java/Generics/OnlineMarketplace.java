
package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Dynamic Online Marketplace
 *
 * Create a generic product catalog that supports Books,
 * Clothing, and Gadgets.
 *
 * Use a bounded generic class to maintain product categories.
 * Implement a generic method to apply discounts to products.
 * Store different product types in a common catalog.
 */

public class OnlineMarketplace {

    // Common interface for product categories
    interface ProductCategory {
        String getCategoryName();
    }

    // Book category
    static class BookCategory implements ProductCategory {
        public String getCategoryName() {
            return "Books";
        }
    }

    // Clothing category
    static class ClothingCategory implements ProductCategory {
        public String getCategoryName() {
            return "Clothing";
        }
    }

    // Gadget category
    static class GadgetCategory implements ProductCategory {
        public String getCategoryName() {
            return "Gadgets";
        }
    }

    // Generic product class
    static class Product<T extends ProductCategory> {
        String name;
        double price;
        T category;

        Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        void displayProduct() {
            System.out.println("Product: " + name);
            System.out.println("Category: " + category.getCategoryName());
            System.out.printf("Price: Rs. %.2f%n", price);
        }
    }

    // Generic method to apply discount
    static <T extends ProductCategory> void applyDiscount(
            Product<T> product, double percentage) {

        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage!");
            return;
        }

        double discount = product.price * percentage / 100;
        product.price = product.price - discount;

        System.out.println(percentage + "% discount applied to "
                + product.name);
    }

    public static void main(String[] args) {

        // Creating products of different categories
        Product<BookCategory> book =
                new Product<>("Java Programming", 500,
                        new BookCategory());

        Product<ClothingCategory> clothing =
                new Product<>("T-Shirt", 800,
                        new ClothingCategory());

        Product<GadgetCategory> gadget =
                new Product<>("Wireless Mouse", 1200,
                        new GadgetCategory());

        // Applying discounts
        applyDiscount(book, 10);
        applyDiscount(clothing, 20);
        applyDiscount(gadget, 15);

        // Common catalog for different product types
        List<Product<?>> catalog = new ArrayList<>();

        catalog.add(book);
        catalog.add(clothing);
        catalog.add(gadget);

        System.out.println("\n--- Marketplace Product Catalog ---");

        for (Product<?> product : catalog) {
            product.displayProduct();
            System.out.println();
        }
    }
}
