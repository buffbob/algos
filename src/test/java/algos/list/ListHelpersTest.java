package algos.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListHelpersTest {

    @Test
    void testMakeRandomArrayOfIntegers() {
        int length = 100;
        int [] integers = ListHelpers.makeRandomArrayOfInts(length);
        ListNode start = new ListNode(integers[0], null);
        ListNode t = null;
        int idx = 1;
        for (int i = 1; i < length; i++) {
            t = new ListNode(integers[i], start);
            start = t;
            idx++;
        }
        // t is the head
        ListNode.iterateThrough(t);
        assertEquals(idx, length);
        assertEquals(start.value, integers[length - 1]);

    }

    @Test
    void testMakeCyclicList() {
        ListNode t = ListHelpers.makeCyclicList(20);
        int idx = 0;
        while(idx < 100) {
            t = t.next;
            idx++;
        }
        assertEquals(idx, 100);
    }

}