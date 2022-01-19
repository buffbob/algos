package algos.list;
import algos.StringAlgos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static algos.list.ListHelpers.makeCyclicList;
import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    static ListNode n1;
    static ListNode n2;
    static ListNode n3;
    static ListNode n4;
    static ListNode n5;
    static ListNode ln1;
    static ListNode ln2;
    static ListNode ln3;
    static ListNode ln4;
    static ListNode ln5;
    static ListNode newNode;
    static ListNode newNode2;



    @BeforeEach
    void init() {
        n1 = new ListNode(0, null); // head
        n2 = new ListNode(2, n1);
        n3 = new ListNode(4, n2);
        n4 = new ListNode(26, n3);
        n5 = new ListNode(28, n4);
        ln1 = new ListNode(0, null); // head
        ln2 = new ListNode(12, ln1);
        ln3 = new ListNode(14, ln2);
        ln4 = new ListNode(16, ln3);
        ln5 = new ListNode(18, ln4);


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
    void testLength() {
        assertEquals(ListNode.length(n1), 1);
        assertEquals(ListNode.length(n2), 2);
        assertEquals(ListNode.length(n5), 5);
    }

    @Test
    void testConstructor2() {
        ListNode newNode = new ListNode(11, null);
        ListNode newNode2 = new ListNode(22, newNode);

        assertEquals(newNode2.next, newNode); // the opposite of addAfter()
    }

    @Test
    void testAddAtEnd() {
        // is length correct?
        assertEquals(ListNode.length(n1), 1);
        ListNode iter = n1;
        ListNode result =  ListNode.addAtEnd(n1, 99);
        // count nodes
        assertEquals(ListNode.length(result), 2);
    }

    @Test
    void testAddAtEnd2() {
        // test all values are correct
        ListNode result =  ListNode.addAtEnd(n5, 99);
        int [] testInts = new int[]{28, 26, 4, 2, 0, 99};
        int idx = 0;
        while (result != null) {
            assertEquals(testInts[idx], result.value);
            idx++;
            result = result.next;
        }
    }

    @Test
    void testAddAtEnd3() {
        // test Null values
        ListNode result =  ListNode.addAtEnd(n5, null);
        Integer [] testInts = new Integer[]{28, 26, 4, 2, 0, null};
        int idx = 0;
        while (result != null) {
            assertEquals(testInts[idx], result.value);
            idx++;
            result = result.next;
        }
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

    @Test
    void testMerge() {
        ListNode t = ListNode.merge(n5, ln5);
        ListNode tt = t;

        int i = 0;
        ListNode temp = n5;
        while(t != null){
            i++;
            if(t.next != null){
                assertTrue((int)t.value >= (int)t.next.value);
            }
            t = t.next;
        }
        assertEquals(tt.value, 28);
        assertEquals(i, 10);
        assertEquals(tt.next.value, 26);
    }

    @Test
    void testIterateThrough() {
//        int i = ListNode.iterateThrough(n5);
//        System.out.println("------");
//        System.out.println("i=" + i);
    }
    @Test
    void testReverse() {
        ListNode i = n5;
        ListNode ii = n5;

        ListNode.iterateThrough(i);
        ListNode r = ListNode.reverse(ii);
        System.out.println("--------");
        ListNode.iterateThrough(r);
    }

    @Test
    void testSwap() {
        testArrayTests();
        // good so far....
        // todo::  much more to test
        ListNode test1 = n5;
        int testValues_swapped [] = new int[]{26,28,4,2,0};// 1 & 2
        ListNode test2 = ListNode.swap(n5, 1, 2);
        ListNode temp = test2;
        for (int i = 0; i < testValues_swapped.length; i++) {
            if(i != 0) {
                temp = temp.next;
            }
            assertEquals(testValues_swapped[i], temp.value);
        }
    }

    @Test
    void testArrayTests() {
        ListNode test1 = n5;
        int testValues [] = new int[]{28,26,4,2,0};
        for (int i = 0; i < testValues.length; i++) {
            if(i != 0) {
                test1 = test1.next;
            }
            System.out.println(test1.value);
            assertEquals(testValues[i], test1.value);

        }
    }

    @Test
    void testIsListCyclic() {
        ListNode ln = ListHelpers.makeCyclicList(20);
        assertTrue(ListNode.isListCyclic(ln) != null);
    }

    @Test
    void sizeList() {
        Integer i = Integer.valueOf("3");
        Integer i1 = Integer.valueOf("4");
        Integer i2 = Integer.valueOf("8");
        Integer i3 = Integer.valueOf("9");
        Integer i4 = Integer.valueOf("1");
        LinkedList<Integer> is = new LinkedList<>();
        is.add(i);is.add(i1);is.add(i2);is.add(i3);is.add(i4);
        assertEquals(5, ListNode.sizeList(is,0));
    }

}