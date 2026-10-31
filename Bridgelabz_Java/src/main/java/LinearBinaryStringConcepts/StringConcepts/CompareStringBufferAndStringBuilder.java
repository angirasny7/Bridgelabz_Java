package LinearBinaryStringConcepts.StringConcepts;

public class CompareStringBufferAndStringBuilder {

    public static void main(String[] args) {

        // Number of times the string will be appended
        int iterations = 1_000_000;

        // ---------------- StringBuilder Performance ----------------

        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Record the starting time
        long startTimeBuilder = System.nanoTime();

        // Append the string 1 million times
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }

        // Record the ending time
        long endTimeBuilder = System.nanoTime();

        // Calculate execution time in milliseconds
        long builderTime = (endTimeBuilder - startTimeBuilder) / 1_000_000;

        // ---------------- StringBuffer Performance ----------------

        // Create a StringBuffer object
        StringBuffer sbf = new StringBuffer();

        // Record the starting time
        long startTimeBuffer = System.nanoTime();

        // Append the string 1 million times
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }

        // Record the ending time
        long endTimeBuffer = System.nanoTime();

        // Calculate execution time in milliseconds
        long bufferTime = (endTimeBuffer - startTimeBuffer) / 1_000_000;

        // Display the execution times
        System.out.println("StringBuilder Time: " + builderTime + " ms");
        System.out.println("StringBuffer Time: " + bufferTime + " ms");

        // Compare the performance
        if (builderTime < bufferTime) {
            System.out.println("StringBuilder is faster.");
        } else if (bufferTime < builderTime) {
            System.out.println("StringBuffer is faster.");
        } else {
            System.out.println("Both took approximately the same time.");
        }
    }
}
