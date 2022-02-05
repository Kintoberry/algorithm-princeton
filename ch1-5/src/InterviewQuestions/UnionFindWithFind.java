/**
 * Union-find with specific canonical element. Add a method find() to the union-find data type so
 * that find(i) returns the largest element in the connected component containing ii.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9}, then the find() method should
 * return 99 for each of the four elements in the connected components.
 */

/*
Solution:
    Use WeightedQuickUnion. Modify how union() is implemented. In particular, maintain the invariant that
    each tree has the maximum value at the root.

    <pseudocode>
    if (weight[tree1] == weight[tree2]) {
        if (root(tree1) > root(tree2)) {
            id[tree2] = tree1;
        } else {
            id[tree1] = tree2;
        }
    } else if (weight[tree1] > weight[tree2]) {

    }
 */
package InterviewQuestions;

public class UnionFindWithFind {
    private int[] id;
    private int[] weight;
    private int count;
    public UnionFindWithFind(int N) {
        count = N;
        weight = new int[N];
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        if (weight[pRoot] >= weight[qRoot]) {
            id[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        } else {
            id[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        }
        count--;
    }
    public int find(int p) {
        return root(p);
    }
    private int parent(int p) {
        return id[p];
    }
    private int root(int p) {
        while (id[p] != p) {
            p = parent(p);
        }
        return p;
    }
    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }
    public int count() {
        return count;
    }

}

