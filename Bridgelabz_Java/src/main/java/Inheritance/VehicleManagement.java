
package Inheritance;

// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle1 {
    int maxSpeed;
    String model;

    Vehicle1(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Maximum Speed: " + maxSpeed + " km/h");
    }
}

// Subclass 1
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Charging the electric vehicle.");
    }

    @Override
    void displayInfo() {
        System.out.println("--- Electric Vehicle ---");
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass 2
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelCapacity;

    PetrolVehicle(int maxSpeed, String model, double fuelCapacity) {
        super(maxSpeed, model);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle.");
    }

    @Override
    void displayInfo() {
        System.out.println("--- Petrol Vehicle ---");
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " litres");
    }
}

// Main class
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle =
                new ElectricVehicle(180, "Tesla Model 3", 75);

        PetrolVehicle petrolVehicle =
                new PetrolVehicle(220, "Honda City", 40);

        electricVehicle.displayInfo();
        electricVehicle.charge();

        System.out.println();

        petrolVehicle.displayInfo();
        petrolVehicle.refuel();

        System.out.println("\n--- Polymorphism Using Refuelable ---");

        Refuelable refuelable = petrolVehicle;
        refuelable.refuel();
    }
}
