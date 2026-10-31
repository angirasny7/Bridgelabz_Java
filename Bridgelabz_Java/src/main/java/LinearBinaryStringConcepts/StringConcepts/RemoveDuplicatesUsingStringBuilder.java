package LinearBinaryStringConcepts.StringConcepts;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesUsingStringBuilder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // StringBuilder stores characters without duplicates
        StringBuilder result = new StringBuilder();

        // HashSet keeps track of characters already visited
        HashSet<Character> seen = new HashSet<>();

        // Traverse each character of the input string
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check whether the character is already present
            if (!seen.contains(ch)) {

                // Append the character if it is encountered for the first time
                result.append(ch);

                // Mark the character as visited
                seen.add(ch);
            }
        }

        // Display the string after removing duplicates
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}
