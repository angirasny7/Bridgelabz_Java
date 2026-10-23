
/*
 * Problem 1: University Management System
 * Create a Student class with public rollNumber, protected name,
 * and private CGPA.
 * Provide public methods to access and modify CGPA.
 * Create a PostgraduateStudent subclass to demonstrate access
 * to protected members.
 */

package Constructor.Level3;

// Parent class
class Student {

    // Public member: accessible from anywhere
    public int rollNumber;

    // Protected member: accessible within the package and subclasses
    protected String name;

    // Private member: accessible only within the Student class
    private double CGPA;

    // Constructor to initialize student details
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access private CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify private CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA! Enter a value between 0 and 10.");
        }
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass extending Student
class PostgraduateStudent extends Student {

    // Additional attribute for postgraduate students
    String specialization;

    // Constructor to initialize postgraduate student details
    PostgraduateStudent(int rollNumber, String name,
                        double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method to demonstrate access to the protected name member
    void displayPostgraduateDetails() {
        System.out.println("\nPostgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);

        // Protected member accessed directly in the subclass
        System.out.println("Name: " + name);

        // Private CGPA accessed through the public getter
        System.out.println("CGPA: " + getCGPA());
        System.out.println("Specialization: " + specialization);
    }
}

// Main class
public class UniversityManagementSystem {

    public static void main(String[] args) {

        // Create a Student object
        Student student = new Student(101, "Rahul", 8.5);

        System.out.println("Student Details:");
        student.displayDetails();

        // Modify CGPA using the public setter method
        student.setCGPA(9.0);

        // Access CGPA using the public getter method
        System.out.println("\nUpdated CGPA: " + student.getCGPA());

        // Create a PostgraduateStudent object
        PostgraduateStudent pgStudent =
                new PostgraduateStudent(201, "Amit", 9.2, "Computer Science");

        // Display postgraduate student details
        pgStudent.displayPostgraduateDetails();
    }
}
