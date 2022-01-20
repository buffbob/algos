package algos.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgsTest {

    @Test
    void testMoveLowerThan() {
        List<Integer> ints = Arrays.asList(1, 5, 4, 3, 8, 2, 5);
        System.out.println(ints);
        int threshold = 4;
        ArrayAlgs.moveLowerThan(ints, threshold);
        System.out.println(ints);
        for (int i = 0; i < 3; i++) {
            assertTrue(ints.get(i) < threshold);
        }
        for (int j = 3; j < ints.size(); j++) {
            assertTrue(ints.get(j) >= threshold);
        }
    }

    @Test
    void testMoveGreaterThan() {
        List<Integer> ints = Arrays.asList(1, 5, 4, 3, 8, 2, 5);
        System.out.println(ints);
        int threshold = 4;
        ArrayAlgs.moveGreaterThan(ints, 4);
        System.out.println(ints);

    }

    @Test
    void testEvenOdd() {
        List<Integer> ints = Arrays.asList(1, 5, 4, 3, 8, 2, 5, 1, 4, 6, 8, 11, 12);
        System.out.println(ints);
        ArrayAlgs.evenOdd(ints);
        for (int i = 0; i < 7; i++) {
            assertTrue(ints.get(i) % 2 == 0);
        }
        System.out.println(ints);
    }
}