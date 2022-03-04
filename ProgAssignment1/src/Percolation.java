import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF UF;
    boolean[][] openClosedMap;
    int numberOfOpenSites;
    int N;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        UF = new WeightedQuickUnionUF(n * n);
        openClosedMap = new boolean[n][n];
        numberOfOpenSites = 0;
        N = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkInput(row, col);
        openClosedMap[row-1][col-1] = true;
        numberOfOpenSites++;
        UF.
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkInput(row, col);
        return openClosedMap[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkInput(row, col);
        int siteNumber = N * row-1 + (col - 1);
        UF.find()
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {

    }

    private void checkInput(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) {
            throw new IllegalArgumentException();
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }

}