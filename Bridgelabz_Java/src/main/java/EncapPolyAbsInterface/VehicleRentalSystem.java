package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 3: Vehicle Rental System
 *
 * Design a rental system with an abstract Vehicle class,
 * Car, Bike, and Truck subclasses, and an Insurable interface.
 *
 * Use private fields for encapsulation, abstract methods for
 * rental calculations, and polymorphism to process different
 * vehicle types through a common Vehicle reference.
 */

// Interface defining insurance-related behavior
interface Insurable {

    // Calculate the insurance cost
    double calculateInsurance();

    // Return insurance information
    String getInsuranceDetails();
}

// Abstract parent class for all vehicles
abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type,
                   double rentalRate) {
        setVehicleNumber(vehicleNumber);
        setType(type);
        setRentalRate(rentalRate);
    }

    // Getter and setter for vehicle number
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null ||
                vehicleNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Vehicle number cannot be empty."
            );
        }
        this.vehicleNumber = vehicleNumber;
    }

    // Getter and setter for vehicle type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Vehicle type cannot be empty."
            );
        }
        this.type = type;
    }

    // Getter and setter for rental rate
    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (!Double.isFinite(rentalRate) || rentalRate < 0) {
            throw new IllegalArgumentException(
                    "Rental rate must be non-negative and finite."
            );
        }
        this.rentalRate = rentalRate;
    }

    // Subclasses calculate rental cost differently
    public abstract double calculateRentalCost(int days);

    // Display common vehicle information
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.printf("Daily Rental Rate: Rs. %.2f%n",
                rentalRate);
    }
}

// Car implementation
class Car extends Vehicle implements Insurable {

    private final String insurancePolicyNumber;
    private static final double INSURANCE_RATE = 0.10;

    public Car(String vehicleNumber, double rentalRate,
               String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber =
                validatePolicyNumber(insurancePolicyNumber);
    }

    // Car rental cost includes a fixed service charge
    @Override
    public double calculateRentalCost(int days) {
        validateDays(days);
        return (getRentalRate() * days) + 500;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        // Do not expose the full policy number
        return "Car insurance policy: "
                + maskPolicyNumber(insurancePolicyNumber);
    }

    private String maskPolicyNumber(String policyNumber) {
        return "****" + policyNumber.substring(
                Math.max(0, policyNumber.length() - 4)
        );
    }

    private String validatePolicyNumber(String policyNumber) {
        if (policyNumber == null ||
                policyNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Policy number cannot be empty."
            );
        }
        return policyNumber;
    }

    private void validateDays(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }
    }
}

// Bike implementation
class Bike extends Vehicle implements Insurable {

    private final String insurancePolicyNumber;
    private static final double INSURANCE_RATE = 0.05;

    public Bike(String vehicleNumber, double rentalRate,
                String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);

        if (insurancePolicyNumber == null ||
                insurancePolicyNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Policy number cannot be empty."
            );
        }

        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }

        // Bikes receive a 5% multi-day discount
        double total = getRentalRate() * days;

        if (days >= 3) {
            total = total * 0.95;
        }

        return total;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance policy: ****"
                + insurancePolicyNumber.substring(
                Math.max(0, insurancePolicyNumber.length() - 4)
        );
    }
}

// Truck implementation
class Truck extends Vehicle implements Insurable {

    private final String insurancePolicyNumber;
    private static final double INSURANCE_RATE = 0.15;

    public Truck(String vehicleNumber, double rentalRate,
                 String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);

        if (insurancePolicyNumber == null ||
                insurancePolicyNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Policy number cannot be empty."
            );
        }

        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be positive."
            );
        }

        // Trucks have an additional daily maintenance charge
        double maintenanceCharge = 1000;
        return (getRentalRate() + maintenanceCharge) * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance policy: ****"
                + insurancePolicyNumber.substring(
                Math.max(0, insurancePolicyNumber.length() - 4)
        );
    }
}

// Main class
public class VehicleRentalSystem {

    // Process any vehicle using a common Vehicle reference
    public static void displayRentalDetails(Vehicle vehicle, int days) {

        System.out.println("\n----------------------");

        vehicle.displayDetails();

        double rentalCost = vehicle.calculateRentalCost(days);

        // All vehicle subclasses implement Insurable
        Insurable insurable = (Insurable) vehicle;
        double insuranceCost = insurable.calculateInsurance();

        System.out.println("Rental Days: " + days);
        System.out.printf("Rental Cost: Rs. %.2f%n", rentalCost);
        System.out.printf("Insurance Cost: Rs. %.2f%n",
                insuranceCost);
        System.out.println(insurable.getInsuranceDetails());

        System.out.printf("Total Cost: Rs. %.2f%n",
                rentalCost + insuranceCost);
    }

    public static void main(String[] args) {

        // Create different vehicles
        Car car = new Car("TN01AB1234", 2000, "CAR123456");
        Bike bike = new Bike("TN02CD5678", 500, "BIKE987654");
        Truck truck = new Truck("TN03EF9012", 5000, "TRUCK456789");

        // Store all vehicle types in one list
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        int rentalDays = 3;

        // Polymorphism invokes each vehicle's own rental calculation
        for (Vehicle vehicle : vehicles) {
            displayRentalDetails(vehicle, rentalDays);
        }
    }
}
