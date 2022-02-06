/**
 * Solution to Creative Exercise 1.4.20 Bitonic Search
 *
 * Status: it's basic implementation of the solution. But it's needs rewriting and more thorough testing of various inputs (incomplete)
 *
 * Description: First find the apex (of tipping point) that is the index of the biggest integer value in the array.
 *              You should use a modified binary search to achieve this.
 *              Then, use apex index to separate the array in to two subarrays, where one is increasing and the other is decreasing.
 *              Lastly, search the target (or key) in increasing subarray using regular binary search algorithms, and search
 *              the target in decreasing subarray using customized binary search algorithm.
 *
 * Efficiency: Process described in the description uses the binary search 3 times. Thus, ~3lgN, where N is the size of the array.
 *
 *
 *
 * Assumption: I only considered an array that is bitonic according to the problem statement. Thus, it should have sequences of
 *             both increasing and decreasing elements. For example, {4, 3, 2}. {1}, {3, 4, 5}, {3, 3}, {8, 7} and etc are not
 *             considered as an input at all.
 */

package CreativeExercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BitonicSearch {
    public static boolean bitonicSearch(int[] arr, int target) {
        int apexIndex = findApex(arr);
        int answer1, answer2;
        answer1 = Arrays.binarySearch(arr, 0, apexIndex, target);
        if (answer1 < 0) {
            // the target is not in this part of the array
            answer2 = reverseBinarySearch(arr, apexIndex, arr.length-1, target);
            if (answer2 < 0) {
                // the target is not in this part of the array
                return false;
            }
        }
        return true;
    }
    /*
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    */

    public static int reverseBinarySearch(int[] a, int low, int high, int key) {
        int lo = low;
        int hi = high;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) lo = mid + 1;
            else if (key > a[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int findApex(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (hi - lo >= 2) { // the array cannot be bitonic when its length is smaller than 3
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid + 1]) {
                lo = mid;
            } else if (arr[mid] > arr[mid + 1]){
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                }
                hi = mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4,5,6, 7, 6,3};
        int[] rea = {7, 6, 5, 4, 3, 2, 1};
        StdOut.println("reverse test: " + BitonicSearch.reverseBinarySearch(rea, 0, rea.length-1, 7));
        StdOut.println(BitonicSearch.findApex(arr));
        StdOut.println(BitonicSearch.bitonicSearch(arr, 77));

        int[] array2 = {1, 5, 4, 3, 2, 0};
        int[] array3 = {2, 4, 8, 16, 32, 1};


        boolean indexOfElement2 = bitonicSearch(array2, 5);
        boolean indexOfElement3 = bitonicSearch(array3, 2);
        boolean indexOfElement4 = bitonicSearch(array3, 99);

    }
}
