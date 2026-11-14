
package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Multi-Level University Course Management System
 *
 * Develop a university course management system that supports
 * Exam-Based, Assignment-Based, and Research-Based courses.
 *
 * Use a generic Course class with a bounded type parameter.
 * Use wildcards to display different course evaluation types.
 */

public class UniversityCourse {

    // Abstract parent class
    static abstract class CourseType {
        abstract String getEvaluationType();
    }

    // Exam-based course
    static class ExamCourse extends CourseType {
        String getEvaluationType() {
            return "Exam-Based";
        }
    }

    // Assignment-based course
    static class AssignmentCourse extends CourseType {
        String getEvaluationType() {
            return "Assignment-Based";
        }
    }

    // Research-based course
    static class ResearchCourse extends CourseType {
        String getEvaluationType() {
            return "Research-Based";
        }
    }

    // Generic course class
    static class Course<T extends CourseType> {
        String courseName;
        T courseType;

        Course(String courseName, T courseType) {
            this.courseName = courseName;
            this.courseType = courseType;
        }

        void displayCourse() {
            System.out.println("Course Name: " + courseName);
            System.out.println("Evaluation: "
                    + courseType.getEvaluationType());
        }
    }

    // Wildcard method to display different courses
    static void displayCourses(
            List<? extends CourseType> courseTypes) {

        for (CourseType type : courseTypes) {
            System.out.println(type.getEvaluationType());
        }
    }

    public static void main(String[] args) {

        // Creating different courses
        Course<ExamCourse> java =
                new Course<>("Java Programming", new ExamCourse());

        Course<AssignmentCourse> database =
                new Course<>("Database Management", new AssignmentCourse());

        Course<ResearchCourse> machineLearning =
                new Course<>("Machine Learning Research",
                        new ResearchCourse());

        // Display course information
        System.out.println("--- University Course Details ---");

        java.displayCourse();
        System.out.println();

        database.displayCourse();
        System.out.println();

        machineLearning.displayCourse();

        // Creating a list of different course types
        List<CourseType> allCourseTypes = new ArrayList<>();

        allCourseTypes.add(new ExamCourse());
        allCourseTypes.add(new AssignmentCourse());
        allCourseTypes.add(new ResearchCourse());

        System.out.println("\n--- Available Evaluation Types ---");

        displayCourses(allCourseTypes);
    }
}
