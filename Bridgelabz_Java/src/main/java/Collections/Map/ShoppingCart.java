package Collections.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Problem: Implement a Shopping Cart
 * Use HashMap for product prices, LinkedHashMap for the order
 * products are added to the cart, and TreeMap to display products
 * sorted by price.
 */
public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Keyboard", 1200.0);
        productPrices.put("Mouse", 600.0);
        productPrices.put("Monitor", 8500.0);

        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Mouse", 2);
        cart.put("Keyboard", 1);
        cart.put("Monitor", 1);

        // TreeMap sorts by price; product name breaks equal-price ties.
        Map<Double, java.util.List<String>> sortedByPrice = new TreeMap<>();
        for (String product : cart.keySet()) {
            sortedByPrice.computeIfAbsent(productPrices.get(product), key -> new java.util.ArrayList<>())
                         .add(product);
        }

        System.out.println("Product prices: " + productPrices);
        System.out.println("Cart insertion order: " + cart);
        System.out.println("Products sorted by price: " + sortedByPrice);

        double total = 0;
        for (Map.Entry<String, Integer> item : cart.entrySet()) {
            total += productPrices.get(item.getKey()) * item.getValue();
        }
        System.out.println("Total: " + total);
    }
}
