
/*
 * Sample Program 5: University Student Management
 * 1. Use a static variable universityName shared by all students.
 * 2. Use a static method displayTotalStudents() to show the student count.
 * 3. Use this to initialize name, rollNumber, and grade.
 * 4. Use a final variable rollNumber that cannot be changed.
 * 5. Use instanceof to check the object type before displaying
 *    student details or updating grades.
 */

package ThisStaticFinal;

// Class to represent a Student
class Student {

    // Static variable shared by all Student objects
    static String universityName = "SRM Institute of Science and Technology";

    // Static variable to count the total number of students
    static int totalStudents = 0;

    // Instance variables
    String name;
    String grade;

    // Final variable: roll number cannot be reassigned
    final int rollNumber;

    // Constructor to initialize student details
    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;

        // Increment the count whenever a student is created
        totalStudents++;
    }

    // Static method to display the total number of students
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to update the student's grade
    void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated successfully.");
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("University Name: " + universityName);
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}

// Main class
public class UniversityStudentManagement {

    public static void main(String[] args) {

        // Create Student objects
        Student student1 = new Student("Rahul Sharma", 101, "A");
        Student student2 = new Student("Priya Singh", 102, "B");

        // Display the total number of students
        Student.displayTotalStudents();

        // Store a Student object in an Object reference
        Object obj = student1;

        // Check the object type before displaying details
        if (obj instanceof Student) {
            System.out.println("\n----- Student 1 Details -----");

            // Typecast Object to Student
            Student student = (Student) obj;
            student.displayDetails();

            // Update the grade after validating the object type
            System.out.println("\nUpdating Student 1 Grade...");
            student.updateGrade("A+");

            // Display updated student details
            System.out.println("\n----- Updated Student 1 Details -----");
            student.displayDetails();
        } else {
            System.out.println("Object is not a Student.");
        }

        // Display the second student's details
        System.out.println("\n----- Student 2 Details -----");
        student2.displayDetails();
    }
}
