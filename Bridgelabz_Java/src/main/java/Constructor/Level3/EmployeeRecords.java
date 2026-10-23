
/*
 * Problem 4: Employee Records
 * Create an Employee class with public employeeID,
 * protected department, and private salary.
 * Write a public method to modify salary.
 * Create a Manager subclass to access employeeID and department.
 */

package Constructor.Level3;

// Parent class
class Employee {

    // Public member: accessible from anywhere
    public int employeeID;

    // Protected member: accessible within the package and subclasses
    protected String department;

    // Private member: accessible only within the Employee class
    private double salary;

    // Constructor to initialize employee details
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify the private salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Public method to access the private salary
    public double getSalary() {
        return salary;
    }
}

// Subclass extending Employee
class Manager extends Employee {

    // Additional attribute for the Manager
    String teamName;

    // Constructor to initialize manager details
    Manager(int employeeID, String department,
            double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    // Method to display manager details
    void displayDetails() {

        // Access public member directly
        System.out.println("Employee ID: " + employeeID);

        // Access protected member directly
        System.out.println("Department: " + department);

        // Access private salary through the public getter
        System.out.printf("Salary: %.2f%n", getSalary());

        System.out.println("Team Name: " + teamName);
    }
}

// Main class
public class EmployeeRecords {

    public static void main(String[] args) {

        // Create a Manager object
        Manager manager = new Manager(
                101, "Engineering", 75000.0, "Development Team"
        );

        // Display initial employee details
        System.out.println("----- Manager Details -----");
        manager.displayDetails();

        // Modify salary using the public setter method
        System.out.println("\nUpdating salary...");
        manager.setSalary(85000.0);

        // Display updated salary
        System.out.printf("Updated Salary: %.2f%n",
                manager.getSalary());
    }
}
