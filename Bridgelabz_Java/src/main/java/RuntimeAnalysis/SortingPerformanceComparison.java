
package RuntimeAnalysis;

import java.util.Arrays;

/*
 * Problem Description:
 * Compare three sorting algorithms: Bubble Sort, Merge Sort
 * and Quick Sort.
 *
 * Bubble Sort repeatedly swaps adjacent elements.
 * Merge Sort divides the array into smaller parts and merges them.
 * Quick Sort partitions the array around a pivot element.
 *
 * Objective:
 * Understand how different sorting algorithms perform
 * when sorting large datasets.
 *
 * Time Complexity:
 * Bubble Sort : O(N^2)
 * Merge Sort  : O(N log N)
 * Quick Sort  : O(N log N) average, O(N^2) worst case.
 */

public class SortingPerformanceComparison {

    // Sorts the array by repeatedly swapping adjacent elements.
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Divides the array into two halves recursively.
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merges two sorted subarrays into one sorted array.
    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves.
        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from the left half.
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right half.
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back into the original array.
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    // Sorts the array using the Quick Sort algorithm.
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            // Find the correct position of the pivot.
            int pivot = partition(arr, low, high);

            // Sort elements before and after the pivot.
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    // Places the pivot in its correct sorted position.
    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot after all smaller elements.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] original = {50, 20, 40, 10, 30};

        // Create separate copies to test each sorting algorithm.
        int[] a = original.clone();
        int[] b = original.clone();
        int[] c = original.clone();

        bubbleSort(a);
        mergeSort(b, 0, b.length - 1);
        quickSort(c, 0, c.length - 1);

        System.out.println("Bubble Sort: " + Arrays.toString(a));
        System.out.println("Merge Sort: " + Arrays.toString(b));
        System.out.println("Quick Sort: " + Arrays.toString(c));
    }
}
