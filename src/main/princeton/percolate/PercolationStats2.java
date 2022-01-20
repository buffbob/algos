package algos.princeton.percolate;/* *****************************************************************************
 *  Name:    Ada Lovelace
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats2 {


    private double[] fractions;
    private int numTrials;

    public PercolationStats2(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("constructors args out of range");

        numTrials = trials;
        fractions = new double [trials];
        for(int trialNum = 0; trialNum < trials; trialNum++) {
            Percolation percolation = new Percolation(n);
            int numOpen = 0;
            while(!percolation.percolates()) {
                int randomRowX = StdRandom.uniform(n) + 1;
                int randomRowY = StdRandom.uniform(n) + 1;
                if (!percolation.isOpen(randomRowX, randomRowY)) {
                    percolation.open(randomRowX, randomRowY);
                    numOpen++;
                }
            }
            fractions[trialNum] = numOpen * 1.0/(n*n);


        }
    }
    //
    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
        return this.mean() - (1.96 * this.stddev()/Math.sqrt(numTrials));
    }

    public double confidenceHi() {
        return this.mean() + (1.96 * this.stddev()/Math.sqrt(numTrials));

    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int numTrials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, numTrials);

        System.out.println("mean = " + ps.mean());
        System.out.println("stddev = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", "
                                   + ps.confidenceHi() + "]");
    }
}
