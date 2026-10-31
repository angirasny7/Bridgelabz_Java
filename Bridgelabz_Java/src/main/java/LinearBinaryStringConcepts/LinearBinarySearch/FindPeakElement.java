package LinearBinaryStringConcepts.LinearBinarySearch;

public class FindPeakElement {

    // Method to find the index of a peak element using Binary Search
    static int findPeak(int[] arr) {

        // Initialize the search boundaries
        int left = 0;
        int right = arr.length - 1;

        // Perform Binary Search
        while (left < right) {

            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the next element,
            // a peak exists at mid or somewhere in the left half
            if (arr[mid] > arr[mid + 1]) {

                // Search the left half including mid
                right = mid;
            }

            // Otherwise, a peak exists in the right half
            else {

                // Search the right half
                left = mid + 1;
            }
        }

        // Return the index of the peak element
        return left;
    }

    public static void main(String[] args) {

        // Initialize the input array
        int[] arr = {1, 3, 20, 4, 1, 0};

        // Handle an empty array
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        // Find the peak element index
        int index = findPeak(arr);

        // Display the peak element and its index
        System.out.println("Peak Element: " + arr[index]);
        System.out.println("Index: " + index);
    }
}
