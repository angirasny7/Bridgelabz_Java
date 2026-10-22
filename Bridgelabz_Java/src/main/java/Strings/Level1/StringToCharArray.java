package Strings.Level1;

import java.util.Scanner;

public class StringToCharArray {

    // Method to convert a string into a character array
    public static char[] getCharacters(String str) {
        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }

        return result;
    }

    // Method to compare two character arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        // Convert using the user-defined method
        char[] result1 = getCharacters(str);

        // Convert using the built-in method
        char[] result2 = str.toCharArray();

        // Display both character arrays
        System.out.print("Characters using user-defined method: ");
        for (char ch : result1) {
            System.out.print(ch + " ");
        }

        System.out.println();

        System.out.print("Characters using toCharArray(): ");
        for (char ch : result2) {
            System.out.print(ch + " ");
        }

        System.out.println();

        // Compare both arrays
        boolean result = compareArrays(result1, result2);

        System.out.println("Are both character arrays equal? " + result);

        sc.close();
    }
}