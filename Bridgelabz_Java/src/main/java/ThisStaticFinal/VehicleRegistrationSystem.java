
/*
 * Sample Program 6: Vehicle Registration System
 * 1. Use a static variable registrationFee shared by all vehicles.
 * 2. Use a static method updateRegistrationFee() to modify the fee.
 * 3. Use this to initialize ownerName, vehicleType, and registrationNumber.
 * 4. Use a final variable registrationNumber to identify each vehicle.
 * 5. Use instanceof to check the object type before displaying
 *    registration details.
 */

package ThisStaticFinal;

// Class to represent a Vehicle
class Vehicle {

    // Static variable shared by all Vehicle objects
    static double registrationFee = 5000.0;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Final variable: registration number cannot be reassigned
    final String registrationNumber;

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType,
            String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update the shared registration fee
    static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated successfully.");
        } else {
            System.out.println("Invalid registration fee.");
        }
    }

    // Instance method to display registration details
    void displayRegistrationDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.printf("Registration Fee: %.2f%n", registrationFee);
    }
}

// Main class
public class VehicleRegistrationSystem {

    public static void main(String[] args) {

        // Create Vehicle objects
        Vehicle vehicle1 = new Vehicle(
                "Rahul Sharma", "Car", "TN01AB1234"
        );

        Vehicle vehicle2 = new Vehicle(
                "Priya Singh", "Motorcycle", "TN02CD5678"
        );

        // Store a Vehicle object in an Object reference
        Object obj = vehicle1;

        // Check the object type before displaying registration details
        if (obj instanceof Vehicle) {
            System.out.println("Object is a Vehicle.");
            System.out.println("\n----- Vehicle 1 Details -----");

            // Typecast Object to Vehicle
            Vehicle vehicle = (Vehicle) obj;
            vehicle.displayRegistrationDetails();
        } else {
            System.out.println("Object is not a Vehicle.");
        }

        // Display the second vehicle's details
        System.out.println("\n----- Vehicle 2 Details -----");
        vehicle2.displayRegistrationDetails();

        // Update the registration fee for all vehicles
        System.out.println("\nUpdating Registration Fee...");
        Vehicle.updateRegistrationFee(6500.0);

        // Display details with the updated fee
        System.out.println("\n----- Updated Vehicle 1 Details -----");
        vehicle1.displayRegistrationDetails();

        System.out.println("\n----- Updated Vehicle 2 Details -----");
        vehicle2.displayRegistrationDetails();
    }
}
