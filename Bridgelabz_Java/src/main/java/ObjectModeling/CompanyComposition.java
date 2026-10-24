
/*
 * Problem 3: Company and Departments (Composition)
 *
 * Create a Company class containing multiple Department objects.
 * Each Department contains Employee objects.
 * Demonstrate composition by managing the lifecycle of departments
 * and employees through the Company object.
 */

package ObjectModeling;

import java.util.ArrayList;

// Employee class
class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    void displayEmployee() {
        System.out.println("    Employee ID: " + employeeId);
        System.out.println("    Employee Name: " + employeeName);
        System.out.println("    Designation: " + designation);
    }
}

// Department class
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Getter to access the private departmentName field
    String getDepartmentName() {
        return departmentName;
    }

    // Create and add an employee to this department
    void addEmployee(int id, String name, String designation) {
        employees.add(new Employee(id, name, designation));
    }

    // Display department and employee details
    void displayDepartment() {
        System.out.println("\nDepartment: " + departmentName);

        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }

    // Remove all employee references
    void removeEmployees() {
        employees.clear();
    }
}

// Company class
public class CompanyComposition {
    private String companyName;
    private ArrayList<Department> departments;
    private boolean active;

    CompanyComposition(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
        this.active = true;
    }

    // Create and add a department to the company
    void addDepartment(String departmentName) {
        if (!active) {
            System.out.println("Company is closed.");
            return;
        }

        departments.add(new Department(departmentName));
    }

    // Add an employee to an existing department
    void addEmployeeToDepartment(
            String departmentName,
            int id,
            String name,
            String designation) {

        if (!active) {
            System.out.println("Company is closed.");
            return;
        }

        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                department.addEmployee(id, name, designation);
                return;
            }
        }

        System.out.println("Department not found: " + departmentName);
    }

    // Display company, departments, and employees
    void displayCompany() {
        if (!active) {
            System.out.println("Company is closed.");
            return;
        }

        System.out.println("Company: " + companyName);

        for (Department department : departments) {
            department.displayDepartment();
        }
    }

    // Close the company and clear contained object references
    void closeCompany() {
        if (!active) {
            return;
        }

        for (Department department : departments) {
            department.removeEmployees();
        }

        departments.clear();
        active = false;

        System.out.println("\nCompany " + companyName + " has been closed.");
        System.out.println(
                "All department and employee references have been removed.");
    }

    public static void main(String[] args) {
        CompanyComposition company =
                new CompanyComposition("Tech Solutions");

        // Create departments
        company.addDepartment("IT");
        company.addDepartment("HR");
        company.addDepartment("Finance");

        // Add employees to departments
        company.addEmployeeToDepartment(
                "IT", 101, "Rahul", "Software Engineer");

        company.addEmployeeToDepartment(
                "IT", 102, "Priya", "Team Lead");

        company.addEmployeeToDepartment(
                "HR", 103, "Amit", "HR Manager");

        company.addEmployeeToDepartment(
                "Finance", 104, "Neha", "Accountant");

        // Display company details
        company.displayCompany();

        // Close the company and remove its contained objects
        company.closeCompany();

        // Verify that the company is closed
        company.displayCompany();
    }
}
