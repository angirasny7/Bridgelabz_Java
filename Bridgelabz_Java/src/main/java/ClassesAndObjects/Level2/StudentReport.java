package ClassesAndObjects.Level2;
import java.util.Scanner;

class Student{
    // Attributes to store student details
    String name;
    int rollNumber;
    double marks;

    // Method to calculate the grade based on marks
    char calculateGrade(){
        if(marks >= 90){
            return 'A';
        }
        else if(marks >= 80){
            return 'B';
        }
        else if(marks >= 70){
            return 'C';
        }
        else if(marks >= 60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    // Method to display student details and grade
    void displayDetails() {
        System.out.println("\n----- Student Report -----");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);

        // Create an object of the Student class
        Student student = new Student();

        // Input student details
        System.out.print("Enter student name: ");
        student.name = input.nextLine();

        System.out.print("Enter roll number: ");
        student.rollNumber = input.nextInt();

        System.out.print("Enter marks (0-100): ");
        student.marks = input.nextDouble();

        // Validate marks before displaying the report
        if (student.marks < 0 || student.marks > 100) {
            System.out.println("Invalid marks! Please enter marks between 0 and 100.");
        } else {
            // Display the student report
            student.displayDetails();
        }

        // Close the Scanner
        input.close();
    }
}
