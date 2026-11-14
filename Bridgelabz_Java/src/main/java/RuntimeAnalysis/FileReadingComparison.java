
package RuntimeAnalysis;

import java.io.*;

/*
 * Problem Description:
 * Compare FileReader and InputStreamReader for reading
 * a large text file.
 *
 * FileReader reads character data from a file.
 * InputStreamReader converts bytes into characters using
 * a specified or default character encoding.
 *
 * Objective:
 * Understand character streams, byte streams and
 * buffered reading performance.
 *
 * Time Complexity:
 * Both approaches: O(N), where N is the number of characters read.
 *
 * Note:
 * InputStreamReader is not automatically faster than FileReader.
 * Buffered reading reduces repeated I/O overhead.
 */

public class FileReadingComparison {

    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\angir\\Desktop\\Bridgelabz_Java\\Bridgelabz_Java\\src\\main\\java\\sample.txt";

        // Measure FileReader performance.
        long start = System.nanoTime();

        try (FileReader fr = new FileReader(fileName)) {

            int ch;

            // Read characters until the end of the file.
            while ((ch = fr.read()) != -1) {
                // Character is read.
            }
        }

        long end = System.nanoTime();

        System.out.println("FileReader Time: "
                + (end - start) / 1_000_000.0 + " ms");

        // Measure InputStreamReader performance.
        start = System.nanoTime();

        try (InputStreamReader isr =
                     new InputStreamReader(
                             new FileInputStream(fileName))) {

            char[] buffer = new char[8192];

            // Read multiple characters using a buffer.
            while (isr.read(buffer) != -1) {
                // Characters are read into the buffer.
            }
        }

        end = System.nanoTime();

        System.out.println("InputStreamReader Time: "
                + (end - start) / 1_000_000.0 + " ms");
    }
}
