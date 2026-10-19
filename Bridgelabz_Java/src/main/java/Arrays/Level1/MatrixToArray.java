package Arrays.Level1;

import java.util.Scanner;

/*
 * Creates a 2D matrix, copies its elements into a 1D array,
 * and displays both arrays.
 */

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = input.nextInt();

        // Validate the dimensions
        if (rows <= 0 || columns <= 0) {
            System.out.println("Error: Rows and columns must be positive.");
            input.close();
            System.exit(0);
        }

        // Create a 2D array to store the matrix elements
        int[][] matrix = new int[rows][columns];

        // Get the matrix elements from the user
        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Create a 1D array to store all matrix elements
        int[] array = new int[rows * columns];
        int index = 0;

        // Copy the 2D array elements into the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 2D matrix
        System.out.println("Original 2D array:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Display the 1D array
        System.out.println("Copied 1D array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        input.close();
    }
}