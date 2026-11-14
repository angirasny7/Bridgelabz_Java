package Exceptions.AdvancedExceptionHandling;
public class RethrowingDivisionException {
    /*
     * Problem: Perform division and rethrow ArithmeticException with context.
     * Handle the rethrown exception in main.
     */
    public static int performDivision(int n, int d) {
        if (d == 0) throw new ArithmeticException("Division by zero");
        return n / d;
    }
    public static int calculate(int n, int d) {
        try {
            return performDivision(n, d);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Calculation failed: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println("Result: " + calculate(20, 0));
        } catch (ArithmeticException e) {
            System.out.println("Unable to calculate division. " + e.getMessage());
        }
    }
}
