/*
Solution to exercise 1.4.1
Note that I didn't write a test code for this.
 */
/*
** Also, note that you cannot use intValue() method of BigInteger class. It only returns 32 least significant
* * bits, which result in returns 0 for non zero values. You can check the code below as an example.
 */

/*
public static void main(String[] args)  {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger(("0"));
        BigInteger c = new BigInteger(("8589934592")); // 8589934592 = 2^33

        BigInteger sum = a.add(a).add(b).add(c);
        System.out.println("Number: " + sum.toString());
        System.out.println("intValue: " + sum.intValue());
        }
 */
package Exercises;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.math.BigInteger;

public class ThreeSumBigInteger {

    // Do not instantiate.
    private ThreeSumBigInteger() { }

    public static void printAll(BigInteger[] a) {
        int n = a.length;
        BigInteger temp = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    temp = temp.add(a[i]).add(a[j]).add(a[k]);
                    if (temp.compareTo(new BigInteger("0")) == 0) {
                        StdOut.println(a[i].toString() + " " + a[j].toString() + " " + a[k].toString());
                    }
                }
            }
        }
    }
    public static int countBigInteger(BigInteger[] a) {
        int n = a.length;
        int count = 0;
        BigInteger temp = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    temp = temp.add(a[i]).add(a[j]).add(a[k]);
                    if (temp.compareTo(new BigInteger("0")) == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
