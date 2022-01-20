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

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class Test {
    public static void main(String[] args) {
        StdOut.println("starting data loading");

        In in = new In(args[0]);
        int N = in.readInt();
        UF uf = new UF(N);
        System.out.println(N);
        while(!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();

            if (!uf.connected(p, q)) {
            // if (!(uf.find(p) == uf.find(q))) {
                uf.union(p, q);
            }
            StdOut.println(p + ":" + q);
        }
    }
}
