package Strings.Extras.Extras1;

import java.util.Scanner;

/*
 * Problem:
 * Compare two strings lexicographically (dictionary order)
 * without using built-in comparison methods.
 */

public class CompareStrings {

    public static String compareStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int minLength = Math.min(length1, length2);

        // Compare characters one by one
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (str1.charAt(i) < str2.charAt(i)) {
                    return "\"" + str1 + "\" comes before \"" + str2
                            + "\" in lexicographical order.";
                } else {
                    return "\"" + str1 + "\" comes after \"" + str2
                            + "\" in lexicographical order.";
                }
            }
        }

        // If all common characters match, compare string lengths
        if (length1 < length2) {
            return "\"" + str1 + "\" comes before \"" + str2
                    + "\" in lexicographical order.";
        } else if (length1 > length2) {
            return "\"" + str1 + "\" comes after \"" + str2
                    + "\" in lexicographical order.";
        } else {
            return "Both strings are equal in lexicographical order.";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("String 1: ");
        String str1 = sc.nextLine();

        System.out.print("String 2: ");
        String str2 = sc.nextLine();

        System.out.println(compareStrings(str1, str2));

        sc.close();
    }
}