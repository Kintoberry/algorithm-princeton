/**
 * This class converts between grid index and linear index.
 * This is necessary as you need to be able to switch between grid index (row, col) to linear index (array)
 * to implement Percolation using WeightedQuickUnionUF, which uses array.
 *
 * In accordance to Percolation class, here we assume any index starts from 1, not 0
 */
public class Converter {
    private int N, maxLength;

    public Converter(int n) {
        N = n;
        maxLength = N * N;
    }

    public int fromGridToLinear(int row, int col) {
        return (N * (row-1)) + col;
    }

    public Integer fromGridToLinearWestSite(int row, int col) {
        int linearIndex = fromGridToLinear(row, col);
        // return null if current position is at column 1, which is the left most column
        if ((linearIndex-1) == 0 || (linearIndex % N) == 1 ) {
            return null;
        }
        return linearIndex - 1;
    }

    public Integer fromGridToLinearEastSite(int row, int col) {
        int linearIndex = fromGridToLinear(row, col);
        // return null if current position is at column N, which is the right most column
        if ((linearIndex+1) > maxLength || ((linearIndex) % N) == 0) {
            return null;
        }
        return linearIndex + 1;
    }

    public Integer fromGridToLinearNorthSite(int row, int col) {
        int linearIndex = fromGridToLinear(row, col);
        // return null if current position is at row 1, which is the first row of the grid
        if (linearIndex >= 1 && linearIndex <= N) {
            return null;
        }
        return linearIndex - N;
    }

    public Integer fromGridToLinearSouthSite(int row, int col) {
        int linearIndex = fromGridToLinear(row, col);
        // return null if current position is at row N, which is the last row of the grid
        if (linearIndex + N >= maxLength) {
            return null;
        }
        return linearIndex + N;
    }
}
