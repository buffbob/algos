package algos.princeton.colinear;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private final Point [] points;
    private final LineSegment[] lines;
    private final int numLines;
    private final int N; // number of points

    public FastCollinearPoints(Point[] p) {
        checkNull(p);
        N = p.length;
        Point[] sortedp = p.clone();
        Arrays.sort(sortedp);
        points = sortedp;
        checkForDuplicates(points);
        lines = findSegments();
        numLines = lines.length;
    }

    public int numberOfSegments() {
        return numLines;
    }

    public LineSegment[] segments() {
        return lines.clone();
    }

    private LineSegment[] findSegments() {
        List<LineSegment> lines = new ArrayList<>();
        int numberOfSegmentsFound = 0;

        for (int i = 0; i < N; i++) {
            Point p = points[i];
            Point[] pointsBySlope = points.clone();
            Arrays.sort(pointsBySlope, p.slopeOrder());
            // points are sorted points
            // points by slope are points sorted by slope they make with 'this' point
            // assert pointsBySlope[0] is 'this' point
            // assert p == pointsBySlope[0];

            // search the sorted by slope order array for like slopes- likely wont go far in this loop
            // unless collinear and one long line.
            // start at index 2
            int index = 1;
            // moving through slope sorted array
            while (index < N) {
                List<Point> possiblyCo = new ArrayList<>();
                double slopeReference = p.slopeTo(pointsBySlope[index]);
                do{
                    possiblyCo.add(pointsBySlope[index++]);
                } while((index < N) && slopeReference == p.slopeTo(pointsBySlope[index]));
                // check length of possiblyCo
                if (possiblyCo.size() >= 3) {
                    possiblyCo.sort(null);
                    if (p.compareTo(possiblyCo.get(0)) < 0) {
                        lines.add(new LineSegment(p, possiblyCo.get(possiblyCo.size() - 1)));
                    }
                }

            }
        }
        return lines.toArray(new LineSegment[0]);
    }
    private void checkForDuplicates(Point[] p) {
        for (int i = 0; i < N - 1; i++) {
            if (p[i].compareTo(p[i+1]) == 0) {
                throw new IllegalArgumentException("There are duplicate points");
            }
        }
    }

    private void checkNull(Point[] p) {
        if (p == null) {
            throw new IllegalArgumentException("Points array is null");
        }
        for (Point point : p) {
            if(point == null) throw new IllegalArgumentException("A point in the array is null");
        }
    }
    public static void main(String[] args) {

        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            // System.out.println(points[i]);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        LineSegment[] ls = collinear.segments();
        System.out.println(ls.length + " segments found");
        for (LineSegment segment : ls) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
