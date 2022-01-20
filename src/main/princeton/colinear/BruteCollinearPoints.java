package algos.princeton.colinear;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints {

    final private int numSegments; // number of found line segments with 4 or more collinear points
    final private LineSegment[] segs;
    final private Point [] points;
    final private int N; // the number of points

    public BruteCollinearPoints(Point [] pts) {
        checkNull(pts);
        N = pts.length;
        Point [] sorted_pts = pts.clone();
        Arrays.sort(sorted_pts);
        points = sorted_pts;
        checkForDuplicates(points);
        segs = findCollinearSegments();
        numSegments = segs.length;
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

    private LineSegment[] findCollinearSegments() {
        // List<LineSegment> segList = new ArrayList<>();
        int number = 0;
        LineSegment [] lines = new LineSegment[N];
        for (int i = 0; i < N - 3; i++) {
            Point temp = points[i];
            for (int j = i + 1; j < N - 2; j++) {
                double slopeAB = temp.slopeTo(points[j]);
                for (int k = j + 1; k < N - 1; k++) {
                    double slopeAC = temp.slopeTo(points[k]);
                    if (slopeAB == slopeAC) {
                        for (int l = k + 1; l < N ; l++) {
                            Point temp2 = points[l];
                            double slopeAD = temp.slopeTo(temp2);
                            if (slopeAB == slopeAD) {
                                lines[number] = new LineSegment(temp, temp2);
                                number++;
                            }
                        }
                    }
                }
            }
        }
        return Arrays.copyOfRange(lines, 0, number);
    }

    public int numberOfSegments() {
        return numSegments;
    }

    public LineSegment[] segments() {
        return segs.clone();
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println("there are " + collinear.numberOfSegments() + " line segments");
        StdDraw.show();
    }
}
