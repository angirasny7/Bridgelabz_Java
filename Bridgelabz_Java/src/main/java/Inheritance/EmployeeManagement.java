
package Inheritance;

// Base class
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: Rs. " + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Manager Details ---");
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer subclass
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary,
              String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Developer Details ---");
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern subclass
class Intern extends Employee {
    String collegeName;

    Intern(String name, int id, double salary, String collegeName) {
        super(name, id, salary);
        this.collegeName = collegeName;
    }

    @Override
    void displayDetails() {
        System.out.println("\n--- Intern Details ---");
        super.displayDetails();
        System.out.println("College Name: " + collegeName);
    }
}

// Main class
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Rahul", 101, 80000, 10);

        Employee developer =
                new Developer("Priya", 102, 60000, "Java");

        Employee intern =
                new Intern("Amit", 103, 15000, "SRM Institute");

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
