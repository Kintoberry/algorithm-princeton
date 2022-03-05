import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private Percolation percolation;
    private int trials;
    private double mean, stddev;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.trials = trials;
        thresholds = new double[trials];
        for (int i  = 0; i < trials; i++) {
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int targetSiteRow = StdRandom.uniform(n);
                int targetSiteCol = StdRandom.uniform(n);
                if (!percolation.isOpen(targetSiteRow, targetSiteCol)) {
                    percolation.open(targetSiteRow, targetSiteCol);
                }
            }
            thresholds[i] = percolation.numberOfOpenSites() / n* n;
        }
        mean = mean();
        stddev = stddev();
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((1.96 * stddev) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((1.96 * stddev) / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("you must supply 2 arguments.");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.printf("%20s = %f", "mean", percolationStats.mean());
        System.out.printf("%20s = %f", "stddev", percolationStats.stddev());
        System.out.printf("%20s = [%f, %f]", "95% confidence interval", percolationStats.confidenceLo(), percolationStats.confidenceHi());

    }

}