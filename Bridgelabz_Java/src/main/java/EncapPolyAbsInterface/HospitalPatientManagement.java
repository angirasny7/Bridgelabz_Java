package EncapPolyAbsInterface;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem 7: Hospital Patient Management
 *
 * Create an abstract Patient class, InPatient and OutPatient
 * subclasses, and a MedicalRecord interface.
 *
 * Use encapsulation to protect patient details and medical records.
 * Use abstraction for billing calculations and polymorphism to
 * process different types of patients through Patient references.
 */

// Interface defining medical record operations
interface MedicalRecord {

    // Add a medical record
    void addRecord(String record);

    // Display the patient's medical records
    void viewRecords();
}

// Abstract parent class representing a patient
abstract class Patient {

    private final int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        if (patientId <= 0) {
            throw new IllegalArgumentException(
                    "Patient ID must be positive."
            );
        }

        this.patientId = patientId;
        setName(name);
        setAge(age);
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Patient name cannot be empty."
            );
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException(
                    "Enter a valid patient age."
            );
        }
        this.age = age;
    }

    // Each patient type calculates its own bill
    public abstract double calculateBill();

    // Display common patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.printf("Total Bill: Rs. %.2f%n",
                calculateBill());
    }
}

// Inpatient implementation
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyRoomCharge;
    private double treatmentCharge;

    // Medical records are kept private
    private final List<String> medicalRecords = new ArrayList<>();

    public InPatient(int patientId, String name, int age,
                     int daysAdmitted, double dailyRoomCharge,
                     double treatmentCharge) {
        super(patientId, name, age);
        setDaysAdmitted(daysAdmitted);
        setDailyRoomCharge(dailyRoomCharge);
        setTreatmentCharge(treatmentCharge);
    }

    public void setDaysAdmitted(int daysAdmitted) {
        if (daysAdmitted <= 0) {
            throw new IllegalArgumentException(
                    "Admission days must be positive."
            );
        }
        this.daysAdmitted = daysAdmitted;
    }

    public void setDailyRoomCharge(double dailyRoomCharge) {
        if (!Double.isFinite(dailyRoomCharge) ||
                dailyRoomCharge < 0) {
            throw new IllegalArgumentException(
                    "Room charge must be non-negative and finite."
            );
        }
        this.dailyRoomCharge = dailyRoomCharge;
    }

    public void setTreatmentCharge(double treatmentCharge) {
        if (!Double.isFinite(treatmentCharge) ||
                treatmentCharge < 0) {
            throw new IllegalArgumentException(
                    "Treatment charge must be non-negative and finite."
            );
        }
        this.treatmentCharge = treatmentCharge;
    }

    // Inpatient bill includes room charges and treatment charges
    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyRoomCharge)
                + treatmentCharge;
    }

    @Override
    public void addRecord(String record) {
        if (record == null || record.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Medical record cannot be empty."
            );
        }
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");

        if (medicalRecords.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        for (String record : medicalRecords) {
            System.out.println("- " + record);
        }
    }
}

// Outpatient implementation
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private double testCharges;

    private final List<String> medicalRecords = new ArrayList<>();

    public OutPatient(int patientId, String name, int age,
                      double consultationFee, double testCharges) {
        super(patientId, name, age);
        setConsultationFee(consultationFee);
        setTestCharges(testCharges);
    }

    public void setConsultationFee(double consultationFee) {
        if (!Double.isFinite(consultationFee) ||
                consultationFee < 0) {
            throw new IllegalArgumentException(
                    "Consultation fee must be non-negative and finite."
            );
        }
        this.consultationFee = consultationFee;
    }

    public void setTestCharges(double testCharges) {
        if (!Double.isFinite(testCharges) || testCharges < 0) {
            throw new IllegalArgumentException(
                    "Test charges must be non-negative and finite."
            );
        }
        this.testCharges = testCharges;
    }

    // Outpatient bill includes consultation and test charges
    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }

    @Override
    public void addRecord(String record) {
        if (record == null || record.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Medical record cannot be empty."
            );
        }
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");

        if (medicalRecords.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        for (String record : medicalRecords) {
            System.out.println("- " + record);
        }
    }
}

// Main class
public class HospitalPatientManagement {

    public static void main(String[] args) {

        // Create different patient types
        InPatient inPatient = new InPatient(
                101, "Rahul", 45, 3, 2000, 5000
        );

        OutPatient outPatient = new OutPatient(
                102, "Priya", 30, 800, 1200
        );

        // Add medical records
        inPatient.addRecord("Admitted for observation.");
        inPatient.addRecord("Treatment completed.");

        outPatient.addRecord("Consultation completed.");
        outPatient.addRecord("Blood test requested.");

        // Polymorphism: process both types using Patient references
        List<Patient> patients = new ArrayList<>();
        patients.add(inPatient);
        patients.add(outPatient);

        for (Patient patient : patients) {
            System.out.println("\n----------------------");

            // The correct subclass billing method is called
            patient.getPatientDetails();

            // Both subclasses implement MedicalRecord
            MedicalRecord record = (MedicalRecord) patient;
            record.viewRecords();
        }
    }
}
