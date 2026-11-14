
package RuntimeAnalysis;

/*
 * Problem Description:
 * Compare the performance of String, StringBuilder and
 * StringBuffer when concatenating multiple strings.
 *
 * String is immutable, so every modification creates a
 * new String object.
 *
 * StringBuilder is mutable and does not provide synchronization.
 *
 * StringBuffer is mutable and provides thread safety
 * through synchronized methods.
 *
 * Objective:
 * Understand which approach is more efficient for
 * repeated string concatenation.
 *
 * Time Complexity:
 * String          : O(N^2) for repeated equal-sized appends.
 * StringBuilder   : O(N) amortized.
 * StringBuffer    : O(N) amortized.
 */

public class StringConcatenationComparison {

    public static void main(String[] args) {

        int n = 10000;

        // String concatenation.
        long start = System.nanoTime();

        String str = "";

        for (int i = 0; i < n; i++) {
            str += "Java";
        }

        long end = System.nanoTime();

        System.out.println("String Time: "
                + (end - start) / 1_000_000.0 + " ms");

        // StringBuilder concatenation.
        start = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("Java");
        }

        end = System.nanoTime();

        System.out.println("StringBuilder Time: "
                + (end - start) / 1_000_000.0 + " ms");

        // StringBuffer concatenation.
        start = System.nanoTime();

        StringBuffer sf = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sf.append("Java");
        }

        end = System.nanoTime();

        System.out.println("StringBuffer Time: "
                + (end - start) / 1_000_000.0 + " ms");
    }
}
