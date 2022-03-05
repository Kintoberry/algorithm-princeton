import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF UF;
    boolean[][] openClosedGrid;
    int numberOfOpenSites;
    int N, UFlength; // N is the width of the grid n x n. Thus, N equals n.
    int northEndPoint, southEndPoint;
    Converter indexConverter;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        // from 1 to n*n are valid sites; index 0 and n*n + 1 are north and south end points, respectively.
        UF = new WeightedQuickUnionUF(n * n + 2);
        northEndPoint = 0;
        southEndPoint = n * n + 1;
        // create (n+1)*(n+1) grid to match the fact that col and row indexes starts with 1, not 0.
        openClosedGrid = new boolean[n+1][n+1];
        numberOfOpenSites = 0;
        N = n;
        UFlength = n * n;
        indexConverter = new Converter(N);
        connectNorthEndPointToFirstRow();
        connectSouthEndPointToLastRow();
    }

    private void connectNorthEndPointToFirstRow() {
        for (int siteIndex = 1; siteIndex <= N; siteIndex++) {
            UF.union(northEndPoint, siteIndex);
        }
    }
    private void connectSouthEndPointToLastRow() {
        for (int i = 0; i < N; i++) {
            UF.union(UFlength-i, southEndPoint);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkInput(row, col);
        if (openClosedGrid[row][col]) {
            return;
        }
        openClosedGrid[row][col] = true;
        numberOfOpenSites++;
        connectWithSurroundingSites(row, col);
    }

    private void connectWithSurroundingSites(int row, int col) {
        int currentIndex = indexConverter.fromGridToLinear(row, col);
        Integer eastSiteIndex = indexConverter.fromGridToLinearEastSite(row, col);
        if (eastSiteIndex != null) {
            UF.union(currentIndex, eastSiteIndex);
        }
        Integer westSiteIndex = indexConverter.fromGridToLinearWestSite(row, col);
        if (westSiteIndex != null) {
            UF.union(currentIndex, westSiteIndex);
        }
        Integer northSiteIndex = indexConverter.fromGridToLinearNorthSite(row, col);
        if (northSiteIndex != null) {
            UF.union(currentIndex, northSiteIndex);
        }
        Integer southSiteIndex = indexConverter.fromGridToLinearSouthSite(row, col);
        if (southSiteIndex != null) {
            UF.union(currentIndex, southSiteIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkInput(row, col);
        return openClosedGrid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkInput(row, col);
        int index = indexConverter.fromGridToLinear(row, col);
        return UF.find(index) == UF.find(northEndPoint);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return UF.find(northEndPoint) == UF.find(southEndPoint);
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