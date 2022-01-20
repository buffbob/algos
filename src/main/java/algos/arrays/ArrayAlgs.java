package algos.arrays;

import java.util.Collections;
import java.util.List;

public class ArrayAlgs {
    /**
     * If an element of the given array is less than threshold then move it
     * to the beginning of said data structure.
     * @param ints A List of Integers.
     * @param threshold The value to compare against the elements of the List, ints.
     * @return Same list but with elements less than threshold at the beginning of the list.
     */
    public static List<Integer> moveLowerThan(List<Integer> ints, int threshold) {
        int start;
        for (start = 0; start < ints.size() - 1; start++) {
            for (int j = start + 1; j < ints.size(); j++) {
                if(ints.get(j) < threshold) {
                    Collections.swap(ints, ints.get(start), ints.get(j));
                    break;
                }
            }
        }
        return ints;
    }

    /**
     * Move all elements greater than threshold to the right of the threshold value.
     * @param ints A List of integers.
     * @param threshold The value to consider when swapping to the end.
     * @return The same list with all items larger than the threshold on the right side
     * of the list.
     */
    public static List<Integer> moveGreaterThan(List<Integer> ints, int threshold) {

        for (int endIdx = ints.size() - 1; endIdx >= 1; endIdx--) {
            for (int t = endIdx - 1; t >= 0; t--) {
                if(ints.get(t) > threshold){
                    Collections.swap(ints, t, endIdx);
                    break;
                }
            }
        }
        return ints;
    }

    /**
     * Given a list of Integers, swap elements such that all even elements are
     * at the beginning and all odd elements are at the end.
     * Divide area into 3 partitions- even, odd, and unclassified. evens and odds while divide the
     * three partitions. To start all are classified as unclassified.
     * @param ints A list of Integers.
     * @return The modified list.
     */
    public static List<Integer> evenOdd(List<Integer> ints){
        int evens = 0; int odds = ints.size() - 1;
        while (evens < odds) {
            if (ints.get(evens) % 2 == 0) {
                evens++;
            } else {
                Collections.swap(ints, evens, odds--);
            }
        }
        return ints;
    }
}
