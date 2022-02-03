package CreativeExercises;
/*
Solution to Creative Exercise 1.5.14
Author: Kinto
 */

public class WeightedQuickUnionByHeight {
    private int[] id;
    private int[] weight;
    private int[] height;
    private int count;
    public WeightedQuickUnionByHeight(int N) {
        count = N;
        weight = new int[N];
        height = new int[N];
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            weight[i] = 1;
            height[i] = 0;
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
            if (weight[pRoot] == weight[qRoot]) {
                // The height of the combined tree grows by 1 if and only if when the two trees are the same
                // The height of the combined tree remains the same if one tree is bigger than the other, since
                // the smaller tree is attached to the root of the bigger tree.
                height[pRoot]++;
            }
        } else {
            if (height[pRoot] < height[qRoot]) {
                id[pRoot] = qRoot;
            } else if (height[pRoot] > height[qRoot]) {
                id[qRoot] = pRoot;
            } else if (height[pRoot] ==  height[qRoot]) {
                id[pRoot] = qRoot;
                height[qRoot]++;
            }
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
