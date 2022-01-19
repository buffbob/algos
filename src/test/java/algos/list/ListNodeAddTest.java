package algos.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListNodeAddTest {
    static ListNode a1;
    static ListNode a2;
    static ListNode a3;
    static ListNode b1;
    static ListNode b2;
    static ListNode b3;
    static ListNode res1;
    static ListNode res2;
    static ListNode res3;

    @BeforeEach
    public void init() {
        a1 = new ListNode(2, null); // head
        a2 = new ListNode(3, a1);
        a3 = new ListNode(4, a2);
        b1 = new ListNode(1, null); // head
        b2 = new ListNode(2, b1);
        b3 = new ListNode(4, b2);
        res1 = new ListNode(3, null); // head
        res2 = new ListNode(5, res1);
        res3 = new ListNode(8, res2);
    }

    @Test
    void simpleWithNoCarry() {
        ListNode result = ListNode.addIntegers(a3, b3);

        while(result != null && res3 != null) {
            assertEquals(result.value, res3.value);
            res3 = res3.next;
            result = result.next;
        }
    }


}
