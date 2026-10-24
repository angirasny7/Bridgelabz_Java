
/*
 * Sample Program 7: Hospital Management System
 * 1. Use a static variable hospitalName shared by all patients.
 * 2. Use a static method getTotalPatients() to display the patient count.
 * 3. Use this to initialize name, age, and ailment in the constructor.
 * 4. Use a final variable patientID to identify each patient.
 * 5. Use instanceof to check the object type before displaying details.
 */

package ThisStaticFinal;

// Class to represent a Patient
class Patient {

    // Static variable shared by all Patient objects
    static String hospitalName = "City Care Hospital";

    // Static variable to count the total number of patients
    static int totalPatients = 0;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Final variable: patient ID cannot be reassigned
    final int patientID;

    // Constructor to initialize patient details
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;

        // Increment the count whenever a patient object is created
        totalPatients++;
    }

    // Static method to display the total number of patients
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Instance method to display patient details
    void displayDetails() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

// Main class
public class HospitalManagementSystem {

    public static void main(String[] args) {

        // Create Patient objects
        Patient patient1 = new Patient(
                "Rahul Sharma", 35, "Fever", 101
        );

        Patient patient2 = new Patient(
                "Priya Singh", 28, "Migraine", 102
        );

        // Display the total number of patients
        Patient.getTotalPatients();

        // Store a Patient object in an Object reference
        Object obj = patient1;

        // Check the object type before displaying details
        if (obj instanceof Patient) {
            System.out.println("\n----- Patient 1 Details -----");

            // Typecast Object to Patient
            Patient patient = (Patient) obj;
            patient.displayDetails();
        } else {
            System.out.println("Object is not a Patient.");
        }

        // Display the second patient's details
        System.out.println("\n----- Patient 2 Details -----");
        patient2.displayDetails();
    }
}
