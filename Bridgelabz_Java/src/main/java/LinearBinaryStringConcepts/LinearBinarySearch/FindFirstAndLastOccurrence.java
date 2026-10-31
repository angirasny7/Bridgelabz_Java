package LinearBinaryStringConcepts.LinearBinarySearch;

public class FindFirstAndLastOccurrence {

    // Method to find the first occurrence of the target
    static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        // Store the first occurrence index
        int first = -1;

        // Perform Binary Search
        while (left <= right) {

            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // Check whether the target is found
            if (arr[mid] == target) {

                // Store the current index
                first = mid;

                // Continue searching in the left half
                right = mid - 1;
            }

            // Search the left half if target is smaller
            else if (arr[mid] > target) {
                right = mid - 1;
            }

            // Search the right half if target is greater
            else {
                left = mid + 1;
            }
        }

        // Return the first occurrence index
        return first;
    }

    // Method to find the last occurrence of the target
    static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        // Store the last occurrence index
        int last = -1;

        // Perform Binary Search
        while (left <= right) {

            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // Check whether the target is found
            if (arr[mid] == target) {

                // Store the current index
                last = mid;

                // Continue searching in the right half
                left = mid + 1;
            }

            // Search the left half if target is smaller
            else if (arr[mid] > target) {
                right = mid - 1;
            }

            // Search the right half if target is greater
            else {
                left = mid + 1;
            }
        }

        // Return the last occurrence index
        return last;
    }

    public static void main(String[] args) {

        // Initialize a sorted array containing duplicate elements
        int[] arr = {1, 2, 2, 2, 3, 4, 5};

        // Define the target element
        int target = 2;

        // Find the first occurrence
        int first = findFirst(arr, target);

        // Find the last occurrence
        int last = findLast(arr, target);

        // Display the results
        if (first != -1) {

            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);

        } else {

            System.out.println("Target element not found.");
        }
    }
}
