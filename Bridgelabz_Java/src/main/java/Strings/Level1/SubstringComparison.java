package Strings.Level1;

import java.util.Scanner;

public class SubstringComparison {

    public static String createSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

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

        System.out.print("Enter a string: ");
        String str = sc.next();

        System.out.print("Enter the start index: ");
        int start = sc.nextInt();

        System.out.print("Enter the end index: ");
        int end = sc.nextInt();

        if (start < 0 || end > str.length() || start > end) {
            System.out.println("Invalid start or end index.");
        } else {

            String result1 = createSubstring(str, start, end);
            String result2 = str.substring(start, end);

            System.out.println("Substring using charAt(): " + result1);
            System.out.println("Substring using substring(): " + result2);

            boolean comparison = compareStrings(result1, result2);

            System.out.println("Are both substrings equal? " + comparison);
        }

        sc.close();
    }
}
