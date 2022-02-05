/**
 * Solution to exercise 1.4.16
 * Author: Kinto
 */

/*
    Running Time: sorting takes O(NlgN), where N is the size of the given array of doubles
                  Because the array is sorted, at each index i, the closest element exists
                  at either i-1 or i+1. Any element at bigger or lower index than that is not the closest.
                  So we can linearly process the sorted array to find the closest pair, which takes O(N)
                  Thus, the running time is O(NlgN).
 */
package CreativeExercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ClosestPair {
    private static class Pair<T> {
        public T a, b; // expose instance variables for convenience
        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }
        public Pair() {
            ;
        }
    }
    public static Pair findClosestPair(double[] a) {
        Arrays.sort(a); // O(NlogN)
        double min = Math.abs(a[0] - a[1]); // assume that the length of array a is at least 2
        // You can use Double.MAX_VALUE if you'd like.

        Pair pair = new Pair(a[0], a[1]);

        for (int i = 1; i < a.length; i++) {  // O(N)
            double gap = Math.abs(a[i] - a[i-1]);
            if (gap <= min) {
                min = gap;
                pair = new Pair(a[i-1], a[i]);
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        double[] a = {
                1.0,
                30000.0,
                55.576,
                1000.01,
                1111,
                2.9,
                1200
        };
        Pair answer = ClosestPair.findClosestPair(a);
        StdOut.println("a: " + answer.a + ", b: " + answer.b);
    }
}
