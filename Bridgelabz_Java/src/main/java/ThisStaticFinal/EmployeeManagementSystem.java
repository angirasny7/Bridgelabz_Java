
/*
 * Sample Program 3: Employee Management System
 * 1. Use a static variable companyName shared by all employees.
 * 2. Use a static method displayTotalEmployees() to show the employee count.
 * 3. Use this to initialize name, id, and designation in the constructor.
 * 4. Use a final variable id that cannot be reassigned after initialization.
 * 5. Use instanceof to check an object's type before displaying details.
 */

package ThisStaticFinal;

// Class to represent an Employee
class Employee {

    // Static variable shared by all Employee objects
    static String companyName = "Tech Solutions";

    // Static variable to count the total number of employees
    static int totalEmployees = 0;

    // Instance variables
    String name;
    String designation;

    // Final variable: employee ID cannot be reassigned
    final int id;

    // Constructor to initialize employee details
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;

        // Increment the employee count whenever an object is created
        totalEmployees++;
    }

    // Static method to display the total number of employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Instance method to display employee details
    void displayDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Designation: " + designation);
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Create Employee objects
        Employee employee1 =
                new Employee("Rahul Sharma", 101, "Software Engineer");

        Employee employee2 =
                new Employee("Priya Singh", 102, "Data Analyst");

        // Call the static method to display the employee count
        Employee.displayTotalEmployees();

        // Store an Employee object in an Object reference
        Object obj = employee1;

        // Check the object's type using instanceof
        if (obj instanceof Employee) {
            System.out.println("\n----- Employee 1 Details -----");

            // Typecast Object to Employee
            Employee employee = (Employee) obj;
            employee.displayDetails();
        } else {
            System.out.println("Object is not an Employee.");
        }

        // Display the second employee's details
        System.out.println("\n----- Employee 2 Details -----");
        employee2.displayDetails();
    }
}
