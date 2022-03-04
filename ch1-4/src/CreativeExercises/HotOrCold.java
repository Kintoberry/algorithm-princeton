/**
 * Solution to Creative Exercise 1.4.34
 * Author: Kinto
 *
 * Status: Incomplete
 */
package CreativeExercises;

public class HotOrCold {
    /*
    private int[] arr;
    private final int secret;
    HotOrCold(int[] arr, int N, int secret) {
        this.secret = secret;
        arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
    }
    public boolean search(int guess) {
        int prevGuessGap = arr.length;
        int lo = 1, hi = arr.length - 1;
        int mid = lo + (lo + hi) / 2;
        return recurse(lo, hi, mid, guess, prevGuessGap);
    }

    private boolean recurse(int lo, int hi, int mid, int guess, int prevGuessGap) {
        if (arr[mid] == secret) {
            return true; // You guessed correctly. Game stops.
        }
        int currentGuessGap = Math.abs(guess - arr[mid]);  // problem description states
    }

     */
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
}
