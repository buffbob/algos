package algos.princeton.percolate;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* *****************************************************************************
 *  Name:    buffbob
 *
 *  Description:  Algorythms 1- Princeton Coursera Course/Assignment 1.
 *
 **************************************************************************** */
public class Percolation {

    private final WeightedQuickUnionUF quickFind;
    private final WeightedQuickUnionUF quickFind_nobackwash;
    private final boolean [] openSites;
    private final int dimension;
    private final int numSites;
    private final int topNodeIndex = 0;
    private final int bottomNodeIndex;
    private int countOfOpenSites = 0;

    /**
     *
     * @param n- the dimension of the square gird ie. the number of rows and/or columns
     */
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        // how many sites
        dimension = n;
        numSites = dimension * dimension;
        openSites = new boolean[numSites + 2];// includes virtual sites top and bottom
        bottomNodeIndex = n * n + 1;
        quickFind = new WeightedQuickUnionUF(numSites + 2);// includes virtual sites top and bottom
        quickFind_nobackwash = new WeightedQuickUnionUF(numSites + 1);// includes virtual site on top
        // OPEN the top and bottom nodes
        openSites[topNodeIndex] = true;
        openSites[bottomNodeIndex] = true;
    }

    /**
     * Convert a 2D coordinate to 1D
     *
     * @param row- index b/n 1 and dimension
     * @param col- index b/n 1 and dimension
     * @return a 1 dimensional mapping of row and col
     */
    private void validate(int row, int col) {
        if (row < 1 || row > dimension) throw new IllegalArgumentException("The row index is out of bounds");
        if (col < 1 || col > dimension) throw new IllegalArgumentException("The col index is out of bounds");
    }

    private int to1D(int row, int col) {
        return dimension * (row - 1) + col;
    }
    private void tryUnion(int row, int col, int neighborRow, int neighborColumn) {
        // only called from open
        // check only neighbor bc row and col alread checked in open
        // to 1D
        int originalLocation = to1D(row, col);
        int neighborLocation = to1D(neighborRow, neighborColumn);
        // check neighbor is in range
        if ((neighborRow > 0 && neighborRow <= dimension) && (neighborColumn > 0 && neighborColumn <= dimension)) {
            // check neighbor is open
            if (isOpen(neighborRow, neighborColumn)) {
                quickFind.union(originalLocation, neighborLocation);
                quickFind_nobackwash.union(originalLocation, neighborLocation);
            }

        }
    }

    private void connectToTop(int row, int col) {
        quickFind.union(0, to1D(row, col));
        quickFind_nobackwash.union(topNodeIndex, to1D(row, col));
    }

    private void connectToBottom(int row, int col) {
        quickFind.union(to1D(row, col), bottomNodeIndex);
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        // do computations if the site is not open already
        if (!openSites[to1D(row, col)]) {
            openSites[to1D(row, col)] = true;
            countOfOpenSites++;
        } else return;
        // if 1st row then connect to the top virtual nodes
        if (row == 1) connectToTop(row, col);
        // if last row then connect to the bottom virtual node
        if (row == dimension) connectToBottom(row, col);

        // try unions from (row, col) to the four neighbors
        tryUnion(row, col, row - 1, col); // west
        tryUnion(row, col, row + 1, col); // east
        tryUnion(row, col, row, col - 1); // north
        tryUnion(row, col, row, col + 1); // south
        }

    /**
     * Is the site (row, col) open?
     *
     * @param row- index b/n 1 and dimension
     * @param col- index b/n 1 and dimension
     * @return true or false
     */
    public boolean isOpen(int row, int col){
        validate(row, col);
        return openSites[to1D(row, col)];
    }

    /**
     * Is the site (row, col) full?
     * @param row- index b/n 1 and dimension
     * @param col- index b/n 1 and dimension
     * @return true?
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
        return quickFind_nobackwash.find(topNodeIndex) ==  quickFind_nobackwash.find(to1D(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickFind.find(topNodeIndex) ==  quickFind.find(bottomNodeIndex);
    }

    // test client (optional)
    public static void main(String[] args) {

        }
}