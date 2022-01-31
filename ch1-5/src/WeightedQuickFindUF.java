/*
Solution to Exercise 1.5.11
Author: Kinto
 */

/*
    Performance characteristics of this algorithms would be the same as unweighted QuickFindUF.
    Only constant factor is added to union method.
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components
    private int[] size;

    public WeightedQuickFindUF(int n) {
        count = n;
        id = new int[n];
        size = new int[n];  // <== added for this solution
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;   // <== added for this solution
        }
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param  p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    @Deprecated
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }


    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   // needed for correctness
        int qID = id[q];   // to reduce the number of array accesses

        // p and q are already in the same component
        if (pID == qID) return;

        int smallerComponentID, biggerComponentID; // <== beginning of the solution
        if (size[pID] >= size[qID]) {
            smallerComponentID = pID;
            biggerComponentID = qID;
        } else {
            smallerComponentID = qID;
            biggerComponentID = pID;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == smallerComponentID) {
                id[i] = biggerComponentID;
            }
        }
        size[biggerComponentID] += size[smallerComponentID]; // <== end of the solution
        count--;
    }

    /*
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
    */

}

    /******************************************************************************
     *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
     *
     *  This file is part of algs4.jar, which accompanies the textbook
     *
     *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
     *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
     *      http://algs4.cs.princeton.edu
     *
     *
     *  algs4.jar is free software: you can redistribute it and/or modify
     *  it under the terms of the GNU General Public License as published by
     *  the Free Software Foundation, either version 3 of the License, or
     *  (at your option) any later version.
     *
     *  algs4.jar is distributed in the hope that it will be useful,
     *  but WITHOUT ANY WARRANTY; without even the implied warranty of
     *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     *  GNU General Public License for more details.
     *
     *  You should have received a copy of the GNU General Public License
     *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
     ******************************************************************************/