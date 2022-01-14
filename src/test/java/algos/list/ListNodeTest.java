package algos.list;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    static ListNode n1;
    static ListNode n2;
    static ListNode n3;
    static ListNode n4;
    static ListNode n5;
    static ListNode newNode;
    static ListNode newNode2;



    @BeforeEach
    void init() {
        n1 = new ListNode(0, null); // head
        n2 = new ListNode(2, n1);
        n3 = new ListNode(4, n2);
        n4 = new ListNode(6, n3);
        n5 = new ListNode(8, n4);
        newNode = new ListNode(11, null);
        newNode2 = new ListNode(22, null);

    }


    @Test
    void testConstructor(){
        assertEquals(n1, n2.next);
        assertEquals(n1, n3.next.next);
        ListNode t = n5;
        int i = 0;
        while(t != null) {i++; t = t.next;}
        assertEquals(i, 5);
    }

    @Test
    void testConstructor2() {
        ListNode newNode = new ListNode(11, null);
        ListNode newNode2 = new ListNode(22, newNode);

        assertEquals(newNode2.next, newNode); // the opposite of addAfter()
    }

    @Test
    void testAddAfter() {
        ListNode.addAfter(newNode, newNode2);
        assertEquals(newNode.next, newNode2);
        assertEquals(newNode2.next, null);
    }

    @Test
    void testAddAfter2() {
        ListNode t = n5;
        ListNode.addAfter(n3, newNode);
        int i = 0;
        while(t != null) {
            i++;
            t = t.next;
        }
        assertEquals(i, 6);
        assertEquals(n3.next, newNode);
        assertEquals(newNode.next.value, n2.value);
        assertEquals(newNode.next, n2);
    }

    @Test
    void testDeleteAfter() {
        ListNode t = n5;
        int i = 0;
        while(t != null) {
            i++;
            t = t.next;
        }
        assertEquals(5, i);
        ListNode.deleteAfter(n3);
        ListNode tt = n5;
        int ii = 0;
        while(tt != null) {
            ii++;
            tt = tt.next;
        }
        assertEquals(4, ii);
        assertEquals(n3.next, n1);
    }

    @Test
    void testSearchList() {
        int t1 = 3;
        int t2 = 4; // n3
        ListNode.searchList(n5, t1); // null
        assertEquals(ListNode.searchList(n5, 3), null);
        assertNotEquals(ListNode.searchList(n5, 4), null);
        assertEquals(ListNode.searchList(n5, 4), n3);
        assertNotEquals(ListNode.searchList(n2, 4), n3);
    }
}