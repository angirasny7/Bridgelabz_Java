package LinkedList.SinglyLinkedList;


/*
 * Problem Statement: Inventory Management System Using Singly Linked List
 *
 * Design an inventory management system using a singly linked list.
 * Each node stores the following item information:
 * Item Name, Item ID, Quantity, and Price.
 *
 * Implement the following operations:
 * 1. Add an item at the beginning of the list.
 * 2. Add an item at the end of the list.
 * 3. Add an item at a specific position.
 * 4. Remove an item using its Item ID.
 * 5. Update the quantity using Item ID.
 * 6. Search for an item using Item ID.
 * 7. Search for an item using Item Name.
 * 8. Calculate the total inventory value.
 * 9. Sort items by Item Name in ascending or descending order.
 * 10. Sort items by Price in ascending or descending order.
 *
 * Requirements:
 * - Use a singly linked list.
 * - Each node must point to the next node.
 * - The last node must point to null.
 * - Handle empty lists and invalid positions.
 * - Do not allow duplicate Item IDs.
 * - Use merge sort to sort the linked list.
 * - Inventory value = Sum of (Price * Quantity).
 */

import java.util.Scanner;

// Represents an item node in the linked list
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    // Initializes item details
    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Manages inventory using a singly linked list
class InventoryLinkedList {

    // Points to the first item
    private Item head;

    // Searches for an item by its ID
    private Item findById(int itemId) {
        Item current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    // Adds an item at the beginning
    public void insertAtBeginning(
            String name, int id, int quantity, double price) {

        // Prevent duplicate item IDs
        if (findById(id) != null) {
            System.out.println("Item ID already exists.");
            return;
        }

        Item newItem = new Item(name, id, quantity, price);

        // Link the new item to the current first item
        newItem.next = head;

        // Update head
        head = newItem;

        System.out.println("Item added at the beginning.");
    }

    // Adds an item at the end
    public void insertAtEnd(
            String name, int id, int quantity, double price) {

        if (findById(id) != null) {
            System.out.println("Item ID already exists.");
            return;
        }

        Item newItem = new Item(name, id, quantity, price);

        // If the list is empty, the new item becomes the head
        if (head == null) {
            head = newItem;
            System.out.println("Item added at the end.");
            return;
        }

        // Traverse to the last node
        Item current = head;

        while (current.next != null) {
            current = current.next;
        }

        // Connect the last node to the new item
        current.next = newItem;

        System.out.println("Item added at the end.");
    }

    // Inserts an item at a specific 1-based position
    public void insertAtPosition(
            String name, int id, int quantity,
            double price, int position) {

        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (findById(id) != null) {
            System.out.println("Item ID already exists.");
            return;
        }

        // Position 1 means insertion at the beginning
        if (position == 1) {
            insertAtBeginning(name, id, quantity, price);
            return;
        }

        Item current = head;

        // Move to the node immediately before the target position
        for (int i = 1;
             i < position - 1 && current != null;
             i++) {
            current = current.next;
        }

        // Position is beyond the valid range
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Insert the new node between existing nodes
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = current.next;
        current.next = newItem;

        System.out.println("Item added at position " + position);
    }

    // Removes an item using its ID
    public void removeItem(int itemId) {

        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // If the first node contains the target item
        if (head.itemId == itemId) {
            Item temp = head;
            head = head.next;

            // Disconnect the removed node
            temp.next = null;

            System.out.println("Item removed successfully.");
            return;
        }

        Item current = head;

        // Find the node immediately before the target item
        while (current.next != null
                && current.next.itemId != itemId) {
            current = current.next;
        }

        // Item was not found
        if (current.next == null) {
            System.out.println("Item not found.");
            return;
        }

        // Skip the node being removed
        Item temp = current.next;
        current.next = temp.next;

        // Disconnect the removed node
        temp.next = null;

        System.out.println("Item removed successfully.");
    }

    // Updates the quantity of an item by ID
    public void updateQuantity(int itemId, int newQuantity) {

        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        Item item = findById(itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        item.quantity = newQuantity;

        System.out.println("Quantity updated successfully.");
    }

    // Searches for an item by ID and displays its details
    public void searchById(int itemId) {

        Item item = findById(itemId);

        if (item == null) {
            System.out.println("Item not found.");
        } else {
            displayItem(item);
        }
    }

    // Searches for items by name
    public void searchByName(String name) {

        Item current = head;
        boolean found = false;

        while (current != null) {
            if (current.itemName.equalsIgnoreCase(name)) {
                displayItem(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Displays one item's details
    private void displayItem(Item item) {
        System.out.println("Item Name : " + item.itemName);
        System.out.println("Item ID   : " + item.itemId);
        System.out.println("Quantity  : " + item.quantity);
        System.out.printf("Price     : %.2f%n", item.price);
        System.out.printf(
                "Item Value: %.2f%n", item.price * item.quantity);
        System.out.println("-----------------------------");
    }

    // Displays all items in the inventory
    public void displayInventory() {

        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item current = head;

        System.out.println("\n--- Inventory Records ---");

        while (current != null) {
            displayItem(current);
            current = current.next;
        }
    }

    // Calculates the total value of all inventory items
    public void calculateTotalValue() {

        Item current = head;
        double totalValue = 0;

        // Add price multiplied by quantity for every item
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }

        System.out.printf(
                "Total Inventory Value: %.2f%n", totalValue);
    }

    // Sorts the inventory using merge sort
    // sortBy: "name" or "price"
    // ascending: true for ascending, false for descending
    public void sortInventory(String sortBy, boolean ascending) {

        if (head == null || head.next == null) {
            System.out.println("Inventory sorted successfully.");
            return;
        }

        // Sort the linked list by rearranging node links
        head = mergeSort(head, sortBy, ascending);

        System.out.println("Inventory sorted successfully.");
    }

    // Recursively divides the list and sorts each half
    private Item mergeSort(
            Item start, String sortBy, boolean ascending) {

        // A list with zero or one node is already sorted
        if (start == null || start.next == null) {
            return start;
        }

        // Find the middle of the list
        Item middle = getMiddle(start);
        Item secondHalf = middle.next;

        // Split the list into two separate halves
        middle.next = null;

        // Sort both halves recursively
        Item left = mergeSort(start, sortBy, ascending);
        Item right = mergeSort(secondHalf, sortBy, ascending);

        // Merge the two sorted halves
        return merge(left, right, sortBy, ascending);
    }

    // Finds the middle node using slow and fast pointers
    private Item getMiddle(Item start) {

        Item slow = start;
        Item fast = start.next;

        // Fast moves two nodes while slow moves one
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merges two sorted lists into one sorted list
    private Item merge(
            Item left, Item right,
            String sortBy, boolean ascending) {

        // Dummy node simplifies building the merged list
        Item dummy = new Item("", 0, 0, 0);
        Item tail = dummy;

        while (left != null && right != null) {

            // Compare the current nodes using the selected field
            int comparison = compareItems(left, right, sortBy);

            // Select the smaller or larger item as required
            if ((ascending && comparison <= 0)
                    || (!ascending && comparison >= 0)) {

                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        // Attach any remaining nodes
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }

    // Compares two items by name or price
    private int compareItems(Item first, Item second, String sortBy) {

        if (sortBy.equalsIgnoreCase("name")) {
            // Case-insensitive alphabetical comparison
            return first.itemName.compareToIgnoreCase(second.itemName);
        }

        // Numerical comparison of prices
        return Double.compare(first.price, second.price);
    }
}

// Main class for the inventory management system
public class InventoryManagementSystem {

    // Reads and validates a non-negative quantity
    private static int readQuantity(Scanner sc) {
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return -1;
        }

        return quantity;
    }

    // Reads and validates a non-negative price
    private static double readPrice(Scanner sc) {
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        if (!Double.isFinite(price) || price < 0) {
            System.out.println("Price must be a valid non-negative number.");
            return -1;
        }

        return price;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();

        int choice;

        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add item at beginning");
            System.out.println("2. Add item at end");
            System.out.println("3. Add item at specific position");
            System.out.println("4. Remove item by ID");
            System.out.println("5. Update item quantity");
            System.out.println("6. Search item by ID");
            System.out.println("7. Search item by name");
            System.out.println("8. Display inventory");
            System.out.println("9. Calculate total inventory value");
            System.out.println("10. Sort inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            String name;
            int id;
            int quantity;
            int position;
            double price;

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    // Read details for a new item
                    System.out.print("Enter item name: ");
                    name = sc.nextLine();

                    System.out.print("Enter item ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    quantity = readQuantity(sc);
                    if (quantity < 0) {
                        break;
                    }

                    price = readPrice(sc);
                    if (price < 0) {
                        break;
                    }

                    // Perform the selected insertion operation
                    if (choice == 1) {
                        inventory.insertAtBeginning(
                                name, id, quantity, price);
                    } else if (choice == 2) {
                        inventory.insertAtEnd(
                                name, id, quantity, price);
                    } else {
                        System.out.print("Enter position (starting from 1): ");
                        position = sc.nextInt();
                        sc.nextLine();

                        inventory.insertAtPosition(
                                name, id, quantity, price, position);
                    }
                    break;

                case 4:
                    // Remove an item by ID
                    System.out.print("Enter item ID to remove: ");
                    id = sc.nextInt();

                    inventory.removeItem(id);
                    break;

                case 5:
                    // Update an item's quantity
                    System.out.print("Enter item ID: ");
                    id = sc.nextInt();

                    quantity = readQuantity(sc);
                    if (quantity >= 0) {
                        inventory.updateQuantity(id, quantity);
                    }
                    break;

                case 6:
                    // Search by item ID
                    System.out.print("Enter item ID to search: ");
                    id = sc.nextInt();

                    inventory.searchById(id);
                    break;

                case 7:
                    // Search by item name
                    System.out.print("Enter item name to search: ");
                    name = sc.nextLine();

                    inventory.searchByName(name);
                    break;

                case 8:
                    // Display all item records
                    inventory.displayInventory();
                    break;

                case 9:
                    // Calculate the total inventory value
                    inventory.calculateTotalValue();
                    break;

                case 10:
                    // Select sorting field and order
                    System.out.println("Sort by:");
                    System.out.println("1. Item Name");
                    System.out.println("2. Price");
                    System.out.print("Enter choice: ");

                    int sortChoice = sc.nextInt();

                    if (sortChoice != 1 && sortChoice != 2) {
                        System.out.println("Invalid sorting field.");
                        break;
                    }

                    System.out.println("Order:");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.print("Enter choice: ");

                    int orderChoice = sc.nextInt();
                    sc.nextLine();

                    if (orderChoice != 1 && orderChoice != 2) {
                        System.out.println("Invalid sorting order.");
                        break;
                    }

                    String sortBy =
                            (sortChoice == 1) ? "name" : "price";

                    boolean ascending = (orderChoice == 1);

                    inventory.sortInventory(sortBy, ascending);

                    // Show the result after sorting
                    inventory.displayInventory();
                    break;

                case 0:
                    System.out.println("Exiting Inventory Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
