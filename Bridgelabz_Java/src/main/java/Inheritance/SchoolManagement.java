
package Inheritance;

// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void displayRole() {
        System.out.println("Role: Person");
    }
}

// Subclass 1
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("--- Teacher Details ---");
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("Role: Teacher");
    }
}

// Subclass 2
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("--- Student Details ---");
        super.displayDetails();
        System.out.println("Grade: " + grade);
        System.out.println("Role: Student");
    }
}

// Subclass 3
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("--- Staff Details ---");
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Role: Staff");
    }
}

// Main class
public class SchoolManagement {
    public static void main(String[] args) {
        Person[] people = {
                new Teacher("Anita", 35, "Mathematics"),
                new Student("Rahul", 16, "10th Grade"),
                new Staff("Suresh", 40, "Administration")
        };

        for (Person person : people) {
            person.displayRole();
            System.out.println();
        }
    }
}
