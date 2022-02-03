/*
My own implementation of QuickFindUF (the most basic implementation in the text)
Author: Kinto
 */

public class UnionFind implements UF{
    private int[] id;
    private int count;
    public UnionFind(int N) {
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
        int targetComponent = id[p];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == targetComponent) {
                id[i] = id[q];
            }
        }
        count--;
    }
    public int find(int p) {
        return id[p];
    }
    public boolean connected (int p, int q) {
        return id[p] == id[q];
    }
    public int count() {
        return count;
    }

}
