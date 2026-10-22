package Strings.Level1;

import java.util.Scanner;

public class CompareStrings {

    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.next();

        System.out.print("Enter the second string: ");
        String str2 = sc.next();

        boolean result1 = compareStrings(str1, str2);
        boolean result2 = str1.equals(str2);

        System.out.println("Result using charAt(): " + result1);
        System.out.println("Result using equals(): " + result2);

        if (result1 == result2) {
            System.out.println("Both results are the same.");
        } else {
            System.out.println("Both results are different.");
        }

        sc.close();
    }
}