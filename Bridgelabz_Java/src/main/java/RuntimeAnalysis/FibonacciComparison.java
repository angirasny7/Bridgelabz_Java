
package RuntimeAnalysis;

/*
 * Problem Description:
 * Compare Recursive and Iterative approaches to calculate
 * the Nth Fibonacci number.
 *
 * Recursive approach calls the same method repeatedly
 * and recalculates previously computed values.
 *
 * Iterative approach calculates Fibonacci numbers using
 * a loop and two variables.
 *
 * Objective:
 * Understand why iteration is more efficient than
 * simple recursion for Fibonacci computation.
 *
 * Time Complexity:
 * Recursive : O(2^N)
 * Iterative : O(N)
 *
 * Auxiliary Space:
 * Recursive : O(N) due to the call stack.
 * Iterative : O(1).
 */

public class FibonacciComparison {

    // Calculates Fibonacci using recursion.
    public static int fibonacciRecursive(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1)
                + fibonacciRecursive(n - 2);
    }

    // Calculates Fibonacci using an iterative approach.
    public static int fibonacciIterative(int n) {

        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        // Calculate each Fibonacci number using the previous two.
        for (int i = 2; i <= n; i++) {

            int sum = a + b;

            a = b;
            b = sum;
        }

        return b;
    }

    public static void main(String[] args) {

        int n = 10;

        // Measure recursive approach.
        long start = System.nanoTime();

        int recursiveResult = fibonacciRecursive(n);

        long end = System.nanoTime();

        System.out.println("Recursive Result: " + recursiveResult);
        System.out.println("Recursive Time: "
                + (end - start) / 1_000_000.0 + " ms");

        // Measure iterative approach.
        start = System.nanoTime();

        int iterativeResult = fibonacciIterative(n);

        end = System.nanoTime();

        System.out.println("Iterative Result: " + iterativeResult);
        System.out.println("Iterative Time: "
                + (end - start) / 1_000_000.0 + " ms");
    }
}
