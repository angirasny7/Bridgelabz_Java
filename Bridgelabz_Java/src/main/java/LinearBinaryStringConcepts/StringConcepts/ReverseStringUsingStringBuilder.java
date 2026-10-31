package LinearBinaryStringConcepts.StringConcepts;

import java.util.Scanner;

public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Create a StringBuilder object with the input string
        StringBuilder sb = new StringBuilder(str);

        // Reverse the string using reverse() method
        sb.reverse();

        // Display the reversed string
        System.out.println("Reversed String: " + sb);

        sc.close();
    }
}
