
/*
 * Problem 3: Vehicle Registration
 * Create a Vehicle class with instance variables ownerName and
 * vehicleType, and a class variable registrationFee shared by all vehicles.
 * Add an instance method to display vehicle details and a class method
 * to update the registration fee.
 */

package Constructor.Level2;

// Class to represent a Vehicle
class Vehicle {

    // Instance variables: separate for each vehicle object
    String ownerName;
    String vehicleType;

    // Class variable: shared by all Vehicle objects
    static double registrationFee = 5000.0;

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.printf("Registration Fee: %.2f%n", registrationFee);
    }

    // Class method to update the registration fee
    static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated successfully.");
        } else {
            System.out.println("Invalid registration fee.");
        }
    }
}

// Main class
public class VehicleRegistration {

    public static void main(String[] args) {

        // Create Vehicle objects
        Vehicle vehicle1 = new Vehicle("Rahul Sharma", "Car");
        Vehicle vehicle2 = new Vehicle("Priya Singh", "Motorcycle");

        // Display vehicle details before updating the fee
        System.out.println("----- Vehicle 1 -----");
        vehicle1.displayVehicleDetails();

        System.out.println("\n----- Vehicle 2 -----");
        vehicle2.displayVehicleDetails();

        // Update the shared registration fee
        System.out.println("\nUpdating Registration Fee...");
        Vehicle.updateRegistrationFee(6500.0);

        // Display vehicle details after updating the fee
        System.out.println("\n----- Updated Vehicle 1 -----");
        vehicle1.displayVehicleDetails();

        System.out.println("\n----- Updated Vehicle 2 -----");
        vehicle2.displayVehicleDetails();
    }
}
