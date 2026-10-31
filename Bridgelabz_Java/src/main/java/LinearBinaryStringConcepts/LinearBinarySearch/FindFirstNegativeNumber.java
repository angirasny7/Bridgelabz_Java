package LinearBinaryStringConcepts.LinearBinarySearch;

public class FindFirstNegativeNumber {

    // Method to find the index of the first negative number
    static int findFirstNegative(int[] arr) {

        // Traverse the array from the beginning
        for (int i = 0; i < arr.length; i++) {

            // Check whether the current element is negative
            if (arr[i] < 0) {

                // Return the index immediately when found
                return i;
            }
        }

        // Return -1 if no negative number is present
        return -1;
    }

    public static void main(String[] args) {

        // Initialize an integer array
        int[] arr = {10, 25, 30, -5, -15, 40};

        // Call the method to find the first negative number
        int index = findFirstNegative(arr);

        // Check whether a negative number was found
        if (index != -1) {

            // Display the negative number and its index
            System.out.println("First Negative Number: " + arr[index]);
            System.out.println("Index: " + index);

        } else {

            // Display message if no negative number exists
            System.out.println("No negative number found.");
        }
    }
}
