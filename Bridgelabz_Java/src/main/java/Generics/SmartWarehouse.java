
package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Smart Warehouse Management System
 *
 * Develop a warehouse system that stores different types of items,
 * such as Electronics, Groceries, and Furniture.
 *
 * Use a generic Storage class with a bounded type parameter
 * to ensure that only WarehouseItem objects can be stored.
 * Use wildcards to display items of different types.
 */

public class SmartWarehouse {

    // Parent class for all warehouse items
    static abstract class WarehouseItem {
        String name;

        WarehouseItem(String name) {
            this.name = name;
        }

        abstract void displayDetails();
    }

    // Electronics item
    static class Electronics extends WarehouseItem {
        Electronics(String name) {
            super(name);
        }

        void displayDetails() {
            System.out.println("Electronics: " + name);
        }
    }

    // Grocery item
    static class Groceries extends WarehouseItem {
        Groceries(String name) {
            super(name);
        }

        void displayDetails() {
            System.out.println("Groceries: " + name);
        }
    }

    // Furniture item
    static class Furniture extends WarehouseItem {
        Furniture(String name) {
            super(name);
        }

        void displayDetails() {
            System.out.println("Furniture: " + name);
        }
    }

    // Generic storage class with an upper bound
    static class Storage<T extends WarehouseItem> {
        List<T> items = new ArrayList<>();

        void addItem(T item) {
            items.add(item);
        }

        List<T> getItems() {
            return items;
        }
    }

    // Wildcard method to display different item types
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Wheat"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics Storage:");
        displayItems(electronicsStorage.getItems());

        System.out.println("\nGrocery Storage:");
        displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture Storage:");
        displayItems(furnitureStorage.getItems());
    }
}
