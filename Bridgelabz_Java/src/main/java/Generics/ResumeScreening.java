
package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: AI-Driven Resume Screening System
 *
 * Develop a resume screening system that supports different
 * job roles such as Software Engineer, Data Scientist,
 * and Product Manager.
 *
 * Use a generic Resume class with a bounded type parameter.
 * Use wildcards to handle different job roles.
 * Implement a generic method to screen resumes.
 */

public class ResumeScreening {

    // Abstract parent class for job roles
    static abstract class JobRole {
        abstract String getRoleName();
    }

    // Software Engineer role
    static class SoftwareEngineer extends JobRole {
        String getRoleName() {
            return "Software Engineer";
        }
    }

    // Data Scientist role
    static class DataScientist extends JobRole {
        String getRoleName() {
            return "Data Scientist";
        }
    }

    // Product Manager role
    static class ProductManager extends JobRole {
        String getRoleName() {
            return "Product Manager";
        }
    }

    // Generic Resume class
    static class Resume<T extends JobRole> {
        String candidateName;
        T jobRole;
        int score;

        Resume(String candidateName, T jobRole, int score) {
            this.candidateName = candidateName;
            this.jobRole = jobRole;
            this.score = score;
        }

        void displayResume() {
            System.out.println("Candidate: " + candidateName);
            System.out.println("Job Role: " + jobRole.getRoleName());
            System.out.println("Score: " + score);
        }
    }

    // Generic method to screen resumes
    static <T extends JobRole> void screenResume(Resume<T> resume) {

        System.out.println("\nScreening: " + resume.candidateName);

        if (resume.score >= 70) {
            System.out.println("Status: Shortlisted");
        } else {
            System.out.println("Status: Rejected");
        }
    }

    // Wildcard method to display different job roles
    static void displayJobRoles(List<? extends JobRole> roles) {

        for (JobRole role : roles) {
            System.out.println(role.getRoleName());
        }
    }

    public static void main(String[] args) {

        // Creating resumes for different job roles
        Resume<SoftwareEngineer> resume1 =
                new Resume<>("Rahul", new SoftwareEngineer(), 85);

        Resume<DataScientist> resume2 =
                new Resume<>("Priya", new DataScientist(), 92);

        Resume<ProductManager> resume3 =
                new Resume<>("Amit", new ProductManager(), 60);

        // Displaying resume details
        System.out.println("--- Resume Details ---");

        resume1.displayResume();
        System.out.println();

        resume2.displayResume();
        System.out.println();

        resume3.displayResume();

        // Screening resumes
        System.out.println("\n--- Resume Screening Results ---");

        screenResume(resume1);
        screenResume(resume2);
        screenResume(resume3);

        // Creating a list of different job roles
        List<JobRole> jobRoles = new ArrayList<>();

        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        // Displaying all available job roles
        System.out.println("\n--- Available Job Roles ---");

        displayJobRoles(jobRoles);
    }
}
