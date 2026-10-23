
/*
 * Problem 2: Online Course Management
 * Create a Course class with instance variables courseName, duration,
 * and fee, and a class variable instituteName shared by all courses.
 * Add an instance method to display course details and a class method
 * to update the institute name for all courses.
 */

package Constructor.Level2;

// Class to represent a Course
class Course {

    // Instance variables: separate for each course object
    String courseName;
    int duration;
    double fee;

    // Class variable: shared among all Course objects
    static String instituteName = "ABC Institute";

    // Constructor to initialize course details
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.printf("Course Fee: %.2f%n", fee);
    }

    // Class method to update the institute name
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

// Main class
public class OnlineCourseManagement {

    public static void main(String[] args) {

        // Create Course objects
        Course course1 = new Course("Java Programming", 6, 15000.0);
        Course course2 = new Course("Web Development", 4, 12000.0);

        // Display course details before updating institute name
        System.out.println("----- Course 1 -----");
        course1.displayCourseDetails();

        System.out.println("\n----- Course 2 -----");
        course2.displayCourseDetails();

        // Update the institute name using the class method
        Course.updateInstituteName("XYZ Learning Institute");

        // Display course details after updating institute name
        System.out.println("\nAfter Updating Institute Name:");

        System.out.println("\n----- Course 1 -----");
        course1.displayCourseDetails();

        System.out.println("\n----- Course 2 -----");
        course2.displayCourseDetails();
    }
}
