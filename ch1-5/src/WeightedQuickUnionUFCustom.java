/*
My own implementation of WeightedQuickUnionUF, which is an improvement of QuickFindUF
Author: Kinto
 */

public class WeightedQuickUnionUFCustom implements UF{
    private int[] id;
    private int[] weight;
    private int count;
    public WeightedQuickUnionUFCustom(int N) {
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
