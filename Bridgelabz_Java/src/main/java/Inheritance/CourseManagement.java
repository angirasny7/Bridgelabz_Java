
package Inheritance;

// Base class
class Course {
    String courseName;
    int duration; // Duration in weeks

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Intermediate subclass
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration,
                 String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Derived subclass
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration,
                     String platform, boolean isRecorded,
                     double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        System.out.println("--- Paid Online Course Details ---");
        super.displayInfo();
        System.out.println("Course Fee: Rs. " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.printf("Final Fee: Rs. %.2f%n",
                fee - (fee * discount / 100));
    }
}

// Main class
public class CourseManagement {
    public static void main(String[] args) {
        Course course = new Course("Java Programming", 8);

        OnlineCourse onlineCourse =
                new OnlineCourse("Web Development", 10,
                        "Coursera", true);

        PaidOnlineCourse paidCourse =
                new PaidOnlineCourse("Full Stack Development", 16,
                        "Udemy", true, 5000, 20);

        System.out.println("--- Course Details ---");
        course.displayInfo();

        System.out.println("\n--- Online Course Details ---");
        onlineCourse.displayInfo();

        System.out.println();
        paidCourse.displayInfo();
    }
}
