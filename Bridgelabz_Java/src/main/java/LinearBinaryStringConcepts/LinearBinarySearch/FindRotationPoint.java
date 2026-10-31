package LinearBinaryStringConcepts.LinearBinarySearch;

public class FindRotationPoint {

    // Method to find the index of the smallest element
    static int findRotationPoint(int[] arr) {

        // Initialize the search boundaries
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left < right) {

            // Calculate the middle index safely
            int mid = left + (right - left) / 2;

            // Smallest element lies in the right half
            if (arr[mid] > arr[right]) {

                // Ignore the left half including mid
                left = mid + 1;
            }

            // Smallest element lies at mid or in the left half
            else {

                // Keep mid as a possible rotation point
                right = mid;
            }
        }

        // Return the index of the smallest element
        return left;
    }

    public static void main(String[] args) {

        // Initialize a rotated sorted array
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        // Check whether the array is empty
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        // Find the rotation point index
        int index = findRotationPoint(arr);

        // Display the smallest element and its index
        System.out.println("Smallest Element: " + arr[index]);
        System.out.println("Rotation Point Index: " + index);
    }
}
