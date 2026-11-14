
package Regex;

import java.util.Scanner;

public class UserRegistration {

    /*
     * Problem: Validate user registration details using Regular Expressions.
     * Validate first name, last name, email, mobile number and password.
     * Test the valid and invalid email samples provided in the assignment.
     */

    // UC1: First name must start with a capital letter and have at least 3 characters.
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2: Last name must start with a capital letter and have at least 3 characters.
    public static boolean validateLastName(String lastName) {
        return lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3 and UC9: Validate email using the assignment's sample requirements.
    public static boolean validateEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9_+-]+(\\.[A-Za-z0-9_+-]+)*"
                        + "@[A-Za-z0-9]+"
                        + "\\.[A-Za-z]{2,}"
                        + "(\\.[A-Za-z]{2})?$";

        return email.matches(emailRegex);
    }

    // UC4: Country code followed by a space and a 10-digit mobile number.
    public static boolean validateMobile(String mobile) {
        return mobile.matches("^[0-9]{1,3} [0-9]{10}$");
    }

    // UC5-UC8: Minimum 8 characters, at least one uppercase,
    // at least one digit and exactly one special character.
    public static boolean validatePassword(String password) {

        String passwordRegex =
                "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,}$)"
                        + "[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$";

        return password.matches(passwordRegex);
    }

    // UC9: Test all valid and invalid email samples from the PDF.
    public static void validateEmailSamples() {

        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        System.out.println("\n========== VALID EMAIL SAMPLES ==========");

        for (String email : validEmails) {
            System.out.println(email + " : " +
                    (validateEmail(email) ? "Valid" : "Invalid"));
        }

        System.out.println("\n========== INVALID EMAIL SAMPLES ==========");

        for (String email : invalidEmails) {
            System.out.println(email + " : " +
                    (validateEmail(email) ? "Valid" : "Invalid"));
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========== USER REGISTRATION ==========");

        // Taking user details
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Mobile Number (e.g. 91 9919819801): ");
        String mobile = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Validating user details
        System.out.println("\n========== VALIDATION RESULTS ==========");

        System.out.println("First Name: " +
                (validateFirstName(firstName) ? "Valid" : "Invalid"));

        System.out.println("Last Name: " +
                (validateLastName(lastName) ? "Valid" : "Invalid"));

        System.out.println("Email: " +
                (validateEmail(email) ? "Valid" : "Invalid"));

        System.out.println("Mobile Number: " +
                (validateMobile(mobile) ? "Valid" : "Invalid"));

        System.out.println("Password: " +
                (validatePassword(password) ? "Valid" : "Invalid"));

        // Testing the email samples provided in the assignment
        validateEmailSamples();

        scanner.close();
    }
}
