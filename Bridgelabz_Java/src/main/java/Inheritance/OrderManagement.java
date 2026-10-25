
package Inheritance;

// Base class
class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }

    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + getOrderStatus());
    }
}

// Intermediate subclass
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Shipped";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Derived subclass
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate,
                   String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Delivered";
    }

    @Override
    void displayInfo() {
        System.out.println("--- Delivered Order Details ---");
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class
public class OrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD101", "2026-10-20");
        ShippedOrder shippedOrder =
                new ShippedOrder("ORD102", "2026-10-21", "TRK12345");
        DeliveredOrder deliveredOrder =
                new DeliveredOrder(
                        "ORD103", "2026-10-22",
                        "TRK67890", "2026-10-24"
                );

        System.out.println("--- Order Details ---");
        order.displayInfo();

        System.out.println("\n--- Shipped Order Details ---");
        shippedOrder.displayInfo();

        System.out.println();
        deliveredOrder.displayInfo();
    }
}
