package algos.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListHelpers {

    public static int [] makeRandomArrayOfInts(int length) {
        int ints [] = new int[length];
        Random r = new Random();
        while(--length >= 0) {
            ints[length] = r.nextInt(100);
        }
        return ints;
    }

    public static ListNode makeRandomListOfIntegers(int length) {
        int [] integers = ListHelpers.makeRandomArrayOfInts(length);
        ListNode start = new ListNode(integers[0], null);
        ListNode t = null;
        for (int i = 1; i < length; i++) {
            t = new ListNode(integers[i], start);
            start = t;

        }
        return t;
    }

    /**
     * iterate to the last node and change its next to some middle node
     * @param length Total length of the original List before making cyclic.
     *              Length after making cyclic is length/2
     * @return The node at the beginning of the cycle and having a length of
     *              length/2.
     */
    public static ListNode makeCyclicList(int length) {
        ListNode list = makeRandomListOfIntegers(length);
        ListNode list2 = list;
        int idx = 0;
        int stop = 0;
        ListNode nodeCycle = null;
        while(list.next != null) {
            if (idx == length/2){
                nodeCycle = list;
            }
            list = list.next;
            idx++;
        }
        list.next = nodeCycle;
        return list2;
    }
}
