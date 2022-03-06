import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF UF;
    private boolean[][] openClosedGrid;
    private int numberOfOpenSites;
    private final int N, UFlength; // N is the width of the grid n x n. Thus, N equals n.
    private final int northEndPoint, southEndPoint;
    private final Converter indexConverter;

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
            /**
             * The order of below union matters. If you look at the implementation of union(), site in the second
             * arument designates the site in the first argument as a parent.
             * This is important, since it's necessary to prevent northEndPoint to becoming the root of any components
             * Otherwise, any sites in the first row that is not open might look to be connected through other open sites
             * in the first row.
             * For example, in 2x2 grid, if you call open(1, 1), open(2, 1), then call to isFull(1, 2) should return false.
             * However, if northEndPoint is the parent of grid(1, 1) and grid(1, 2), isFull(...
             * _______
             * |  |  |
             * -------
             * |  |  |
             * -------
             */
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
        if (eastSiteIndex != null && isOpen(row,col+1)) {
            UF.union(currentIndex, eastSiteIndex);
        }
        Integer westSiteIndex = indexConverter.fromGridToLinearWestSite(row, col);
        if (westSiteIndex != null && isOpen(row, col-1)) {
            UF.union(currentIndex, westSiteIndex);
        }
        Integer northSiteIndex = indexConverter.fromGridToLinearNorthSite(row, col);
        if (northSiteIndex != null && isOpen(row-1, col)) {
            UF.union(currentIndex, northSiteIndex);
        }
        Integer southSiteIndex = indexConverter.fromGridToLinearSouthSite(row, col);
        if (southSiteIndex != null && isOpen(row+1, col)) {
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
        if (!isOpen(row, col)) {
            return false;
        }
        int index = indexConverter.fromGridToLinear(row, col);
        return UF.find(index) == UF.find(northEndPoint);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // this is for the corner case where the grid is 1x1
        if (numberOfOpenSites() == 0) {
            return false;
        }
        int north = UF.find(northEndPoint);
        int south = UF.find(southEndPoint);
        return north == south;
        // return UF.find(northEndPoint) == UF.find(southEndPoint);
    }

    private void checkInput(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) {
            throw new IllegalArgumentException();
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation per = new Percolation(4);
        if (per.percolates()) {
            System.out.println("location 1: error percolation");
        }
        per.open(3, 3);
        if (!per.isOpen(3, 3)) {
            System.out.println("location 2: error isOpen");
        }
        per.open(2, 2);
        per.open(2, 3);
        per.open(1, 2);
        if (!per.isFull(3, 3)) {
            System.out.println("location 3: error isFull");
        }
        if (!per.isFull(1, 2)) {
            System.out.println("location 4: error isFull");
        }
        if (per.percolates()) {
            System.out.println("location 5: error percolation");
        }
        per.open(4, 3);
        if (!per.percolates()) {
            System.out.println("location 6: error percolation");
        }
    }

}