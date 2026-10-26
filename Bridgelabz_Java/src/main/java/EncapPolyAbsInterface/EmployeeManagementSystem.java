package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 1: Employee Management System
 *
 * Description:
 * Create an employee management system using an abstract Employee class,
 * FullTimeEmployee and PartTimeEmployee subclasses, and a Department
 * interface.
 *
 * Implement encapsulation using private fields and getter/setter methods.
 * Use abstraction for salary calculation and polymorphism to process
 * different employee types through Employee references.
 */

// Interface defining department-related behavior
interface Department {

    // Assign an employee to a department
    void assignDepartment(String departmentName);

    // Return the employee's department details
    String getDepartmentDetails();
}

// Abstract class representing a general employee
abstract class Employee {

    // Private fields provide encapsulation
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor initializes common employee details
    public Employee(int employeeId, String name, double baseSalary) {
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
    }

    // Getter and setter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be positive."
            );
        }
        this.employeeId = employeeId;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Employee name cannot be empty."
            );
        }
        this.name = name;
    }

    // Getter and setter for baseSalary
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (!Double.isFinite(baseSalary) || baseSalary < 0) {
            throw new IllegalArgumentException(
                    "Base salary must be non-negative and finite."
            );
        }
        this.baseSalary = baseSalary;
    }

    // Subclasses must provide their own salary calculation
    public abstract double calculateSalary();

    // Common method inherited by all employee types
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.printf("Base Salary: %.2f%n", baseSalary);
        System.out.printf("Calculated Salary: %.2f%n",
                calculateSalary());
    }
}

// Full-time employee implementation
class FullTimeEmployee extends Employee implements Department {

    private String departmentName;

    public FullTimeEmployee(int employeeId, String name,
                            double baseSalary) {
        super(employeeId, name, baseSalary);
        this.departmentName = "Unassigned";
    }

    // Full-time employees receive their fixed base salary
    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String departmentName) {
        if (departmentName == null ||
                departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Department name cannot be empty."
            );
        }
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}

// Part-time employee implementation
class PartTimeEmployee extends Employee implements Department {

    private int hoursWorked;
    private double hourlyRate;
    private String departmentName;

    public PartTimeEmployee(int employeeId, String name,
                            double baseSalary, int hoursWorked,
                            double hourlyRate) {
        super(employeeId, name, baseSalary);
        setHoursWorked(hoursWorked);
        setHourlyRate(hourlyRate);
        this.departmentName = "Unassigned";
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException(
                    "Hours worked cannot be negative."
            );
        }
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (!Double.isFinite(hourlyRate) || hourlyRate < 0) {
            throw new IllegalArgumentException(
                    "Hourly rate must be non-negative and finite."
            );
        }
        this.hourlyRate = hourlyRate;
    }

    // Part-time salary depends on hours worked and hourly rate
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }

    @Override
    public void assignDepartment(String departmentName) {
        if (departmentName == null ||
                departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Department name cannot be empty."
            );
        }
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}

// Main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Create different employee types
        FullTimeEmployee fullTime = new FullTimeEmployee(
                101, "Rahul", 50000
        );

        PartTimeEmployee partTime = new PartTimeEmployee(
                102, "Priya", 10000, 80, 200
        );

        // Assign departments through the interface methods
        fullTime.assignDepartment("Engineering");
        partTime.assignDepartment("Marketing");

        // Polymorphism: store different subclasses in an Employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(fullTime);
        employees.add(partTime);

        // The correct overridden methods execute for each object
        for (Employee employee : employees) {
            System.out.println("\n----------------------");
            employee.displayDetails();

            // Access department behavior through the interface
            Department department = (Department) employee;
            System.out.println(department.getDepartmentDetails());
        }
    }
}

