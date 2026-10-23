
/*
 * Question: Create a Person class with a copy constructor
 * that copies another person's attributes.
 */

package Constructor.Level1;

// Class to represent a Person
class Person {

    // Attributes to store person details
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Main class
public class PersonDemo {

    public static void main(String[] args) {

        // Create the original Person object
        Person person1 = new Person("Rahul", 22);

        // Create a copy using the copy constructor
        Person person2 = new Person(person1);

        // Display the original person's details
        System.out.println("Original Person:");
        person1.displayDetails();

        // Display the copied person's details
        System.out.println("\nCopied Person:");
        person2.displayDetails();
    }
}
