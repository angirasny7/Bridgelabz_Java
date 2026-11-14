
package Lambda;

import java.util.function.Predicate;

/*
 * Problem: User Registration using Lambda Expressions.
 * Validate first name, last name, email, mobile number, and password
 * using Lambda Expressions and Predicate.
 */

public class UserRegistration {

    public static void main(String[] args) {

        // UC 1: Validate First Name
        // Starts with uppercase and contains minimum 3 characters
        Predicate<String> firstNameValidator =
                name -> name != null && name.matches("[A-Z][a-zA-Z]{2,}");

        // UC 2: Validate Last Name
        // Starts with uppercase and contains minimum 3 characters
        Predicate<String> lastNameValidator =
                name -> name != null && name.matches("[A-Z][a-zA-Z]{2,}");

        // UC 3 and UC 9: Validate Email
        Predicate<String> emailValidator =
                email -> email != null &&
                        email.matches("^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$");

        // UC 4: Validate Mobile Number
        // Two-digit country code, space, and 10-digit mobile number
        Predicate<String> mobileValidator =
                mobile -> mobile != null &&
                        mobile.matches("[0-9]{2} [0-9]{10}");

        // UC 5, UC 6, UC 7 and UC 8: Validate Password
        // Minimum 8 characters, one uppercase, one digit,
        // and exactly one special character
        Predicate<String> passwordValidator =
                password -> password != null &&
                        password.length() >= 8 &&
                        password.matches(".*[A-Z].*") &&
                        password.matches(".*[0-9].*") &&
                        password.replaceAll("[a-zA-Z0-9]", "").length() == 1;

        // User registration details
        String firstName = "Angira";
        String lastName = "Yadav";
        String email = "abc.xyz@bl.co.in";
        String mobile = "91 9919819801";
        String password = "Abcd123@";

        // Validate individual fields
        System.out.println("----- User Registration Validation -----");

        System.out.println("First Name: " +
                (firstNameValidator.test(firstName) ? "Valid" : "Invalid"));

        System.out.println("Last Name: " +
                (lastNameValidator.test(lastName) ? "Valid" : "Invalid"));

        System.out.println("Email: " +
                (emailValidator.test(email) ? "Valid" : "Invalid"));

        System.out.println("Mobile Number: " +
                (mobileValidator.test(mobile) ? "Valid" : "Invalid"));

        System.out.println("Password: " +
                (passwordValidator.test(password) ? "Valid" : "Invalid"));

        // Check whether all user details are valid
        boolean isValidUser =
                firstNameValidator.test(firstName) &&
                        lastNameValidator.test(lastName) &&
                        emailValidator.test(email) &&
                        mobileValidator.test(mobile) &&
                        passwordValidator.test(password);

        System.out.println("-----------------------------------------");

        if (isValidUser) {
            System.out.println("User Registration Successful!");
        } else {
            System.out.println("User Registration Failed!");
        }
    }
}
