
package Inheritance;

// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person1 {
    String name;
    int id;

    Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Subclass 1
class Chef extends Person implements Worker {
    String specialization;

    Chef(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties: Preparing and cooking food.");
    }

    void displayInfo() {
        System.out.println("--- Chef Details ---");
        displayDetails();
        System.out.println("Specialization: " + specialization);
        performDuties();
    }
}

// Subclass 2
class Waiter extends Person implements Worker {
    String shift;

    Waiter(String name, int id, String shift) {
        super(name, id);
        this.shift = shift;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties: Taking orders and serving food.");
    }

    void displayInfo() {
        System.out.println("--- Waiter Details ---");
        displayDetails();
        System.out.println("Shift: " + shift);
        performDuties();
    }
}

// Main class
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Priya", 102, "Evening");

        chef.displayInfo();

        System.out.println();

        waiter.displayInfo();

        System.out.println("\n--- Polymorphism Using Worker Interface ---");

        Worker[] workers = {chef, waiter};

        for (Worker worker : workers) {
            worker.performDuties();
        }
    }
}
