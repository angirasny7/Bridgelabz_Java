
/*
 * Question: Car Rental System
 * Create a CarRental class with attributes customerName, carModel,
 * and rentalDays. Add constructors to initialize the rental details
 * and calculate the total rental cost.
 */

package Constructor.Level1;

// Class to represent a Car Rental
class CarRental {

    // Attributes to store rental details
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Not Selected";
        rentalDays = 0;
        costPerDay = 0.0;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel,
              int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    // Method to calculate the total rental cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    // Method to display rental details
    void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Cost Per Day: %.2f%n", costPerDay);
        System.out.printf("Total Rental Cost: %.2f%n",
                calculateTotalCost());
        System.out.println();
    }
}

// Main class
public class CarRentalSystem {

    public static void main(String[] args) {

        // Create an object using the default constructor
        CarRental rental1 = new CarRental();

        // Create an object using the parameterized constructor
        CarRental rental2 = new CarRental(
                "Rahul Sharma", "Honda City", 3, 2000.0
        );

        // Display default rental details
        System.out.println("Rental 1 (Default Constructor):");
        rental1.displayDetails();

        // Display initialized rental details
        System.out.println("Rental 2 (Parameterized Constructor):");
        rental2.displayDetails();
    }
}
