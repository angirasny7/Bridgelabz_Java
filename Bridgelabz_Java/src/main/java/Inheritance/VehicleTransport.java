
package Inheritance;

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Maximum Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car subclass
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Car Details ---");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass
class Truck extends Vehicle {
    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Truck Details ---");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tonnes");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    boolean hasCarrier;

    Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Motorcycle Details ---");
        super.displayInfo();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}

// Main class
public class VehicleTransport {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(200, "Petrol", 5),
                new Truck(120, "Diesel", 15.5),
                new Motorcycle(150, "Petrol", true)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}
