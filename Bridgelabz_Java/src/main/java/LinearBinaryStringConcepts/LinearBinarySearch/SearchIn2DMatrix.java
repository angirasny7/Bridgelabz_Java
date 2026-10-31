package LinearBinaryStringConcepts.LinearBinarySearch;

public class SearchIn2DMatrix {

    // Method to search for a target value using Binary Search
    static boolean searchMatrix(int[][] matrix, int target) {

        // Get the number of rows
        int rows = matrix.length;

        // Get the number of columns
        int columns = matrix[0].length;

        // Treat the 2D matrix as a flattened 1D array
        int left = 0;
        int right = rows * columns - 1;

        // Perform Binary Search
        while (left <= right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // Convert 1D index into 2D row and column indices
            int row = mid / columns;
            int col = mid % columns;

            // Get the middle element
            int value = matrix[row][col];

            // Check whether the target is found
            if (value == target) {
                return true;
            }

            // Search the left half if target is smaller
            else if (value > target) {
                right = mid - 1;
            }

            // Search the right half if target is greater
            else {
                left = mid + 1;
            }
        }

        // Return false if the target is not present
        return false;
    }

    public static void main(String[] args) {

        // Initialize a sorted 2D matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        // Define the target element
        int target = 16;

        // Search for the target in the matrix
        boolean result = searchMatrix(matrix, target);

        // Display the search result
        if (result) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }
}
