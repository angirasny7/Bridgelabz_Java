package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 8: Ride-Hailing Application
 *
 * Create an abstract Vehicle class, Car, Bike, and Auto subclasses,
 * and a GPS interface.
 *
 * Use encapsulation to protect vehicle and driver information.
 * Use abstraction for fare calculation and polymorphism to calculate
 * fares for different vehicle types using a common Vehicle reference.
 */

// Interface defining GPS-related behavior
interface GPS {

    // Return the current location
    String getCurrentLocation();

    // Update the current location
    void updateLocation(String newLocation);
}

// Abstract parent class representing a ride-hailing vehicle
abstract class Vehicle2 {

    private final String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle2(String vehicleId, String driverName,
                   double ratePerKm) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Vehicle ID cannot be empty."
            );
        }

        this.vehicleId = vehicleId;
        setDriverName(driverName);
        setRatePerKm(ratePerKm);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName == null || driverName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Driver name cannot be empty."
            );
        }
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (!Double.isFinite(ratePerKm) || ratePerKm < 0) {
            throw new IllegalArgumentException(
                    "Rate per kilometer must be non-negative and finite."
            );
        }
        this.ratePerKm = ratePerKm;
    }

    // Each vehicle type calculates its own fare
    public abstract double calculateFare(double distance);

    // Display common vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.printf("Rate per KM: Rs. %.2f%n", ratePerKm);
    }
}

// Car implementation
class Car1 extends Vehicle2 implements GPS {

    private String currentLocation;
    private static final double BASE_FARE = 50.0;

    public Car1(String vehicleId, String driverName,
               double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        updateLocation(currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        validateDistance(distance);

        // Car fare includes a base fare
        return BASE_FARE + (getRatePerKm() * distance);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Location cannot be empty."
            );
        }
        this.currentLocation = newLocation;
    }

    private void validateDistance(double distance) {
        if (!Double.isFinite(distance) || distance <= 0) {
            throw new IllegalArgumentException(
                    "Distance must be positive and finite."
            );
        }
    }
}

// Bike implementation
class Bike1 extends Vehicle2 implements GPS {

    private String currentLocation;
    private static final double BASE_FARE = 20.0;

    public Bike1(String vehicleId, String driverName,
                double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        updateLocation(currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        if (!Double.isFinite(distance) || distance <= 0) {
            throw new IllegalArgumentException(
                    "Distance must be positive and finite."
            );
        }

        // Bike fare includes a smaller base fare
        return BASE_FARE + (getRatePerKm() * distance);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Location cannot be empty."
            );
        }
        this.currentLocation = newLocation;
    }
}

// Auto-rickshaw implementation
class Auto extends Vehicle2 implements GPS {

    private String currentLocation;
    private static final double BASE_FARE = 30.0;

    public Auto(String vehicleId, String driverName,
                double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        updateLocation(currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        if (!Double.isFinite(distance) || distance <= 0) {
            throw new IllegalArgumentException(
                    "Distance must be positive and finite."
            );
        }

        // Auto fare includes its own base fare
        return BASE_FARE + (getRatePerKm() * distance);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        if (newLocation == null || newLocation.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Location cannot be empty."
            );
        }
        this.currentLocation = newLocation;
    }
}

// Main class
public class RideHailingApplication {

    // Calculate and display the fare for any vehicle
    public static void calculateRideFare(Vehicle2 vehicle,
                                         double distance) {

        System.out.println("\n----------------------");

        vehicle.getVehicleDetails();

        // Polymorphism calls the correct fare calculation
        double fare = vehicle.calculateFare(distance);

        System.out.println("Distance: " + distance + " km");
        System.out.printf("Total Fare: Rs. %.2f%n", fare);

        // All subclasses implement GPS
        GPS gps = (GPS) vehicle;
        System.out.println(
                "Current Location: " + gps.getCurrentLocation()
        );
    }

    public static void main(String[] args) {

        // Create different ride options
        Car1 car = new Car1(
                "CAR101", "Rahul", 15, "T. Nagar"
        );

        Bike1 bike = new Bike1(
                "BIKE102", "Priya", 8, "Anna Nagar"
        );

        Auto auto = new Auto(
                "AUTO103", "Arun", 12, "Adyar"
        );

        // Update a vehicle's location
        bike.updateLocation("Velachery");

        // Store all vehicle types in one list
        List<Vehicle2> vehicles = new ArrayList<>();

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        double distance = 10;

        // Process every ride using the Vehicle reference
        for (Vehicle2 vehicle : vehicles) {
            calculateRideFare(vehicle, distance);
        }
    }
}
