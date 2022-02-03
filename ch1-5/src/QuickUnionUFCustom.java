/*
My own implementation of QuickUnionUF
Author: Kinto
 */

public class QuickUnionUFCustom implements UF{
    private int[] id;
    private int count;
    public QuickUnionUFCustom(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        id[root(p)] = root(q);
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
