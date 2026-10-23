package ClassesAndObjects.Level1;
import java.util.Scanner;
/*
 * Question: Display Employee Details
 * Create an Employee class with attributes name, id, and salary.
 * Add a method to display the employee details.
 */

//Class to represent an Employee
class Employee{
    //Attributes to store employee details
    String name;
    int id;
    double salary;

    //Method to display employee details
    void displayDetails(){
        System.out.println("\n----- Employee Details -----");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }

}
public class EmployeeDetails {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Create an object of the Employee Class
        Employee emp = new Employee();

        //Input employee details
        System.out.print("Enter employee name: ");
        emp.name = input.nextLine();

        System.out.print("Enter employee ID: ");
        emp.id = input.nextInt();

        System.out.print("Enter employee salary: ");
        emp.salary = input.nextDouble();

        //Call the method to display employee details
        emp.displayDetails();

        input.close();


    }
}
